/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var labelCommandeClient = [];
var chartCommandeClient = 'commande-client';
var pannelCommandeClient = 'panel-commande-client';
var commandeClient = document.getElementById(chartCommandeClient).getContext('2d');
var commandeClient = null;
function initCommandeClient(label, data) {
    
    commandeClient = new Chart(document.getElementById(chartCommandeClient), {
        type: 'bar',
        data: {
            labels: label,
            datasets: data
        },
        options: {
            title: {
                display: true,
                text: 'Statistique des commandes mensuel'
            }
        }
    });
}
function getCommandeClient() {
    debut = document.getElementById("debut-commande").value;
    fin = document.getElementById("fin-commande").value;
    labelCommandeClient = [];
    var urlParams = new URLSearchParams(location.search);
    var idClient = +urlParams.getAll('idClient');
    $.ajax({
        url: "evenementiel/webservice/getCommande",
        type: "get", //send it through get method
        data: {
            debut: debut,
            fin: fin,
            idClient: idClient
        },
        success: function (data) {
            
            var listData = [];
            listData.push({label: 'Nombre de commande', backgroundColor: '#' + (Math.random() * 0xFFFFFF << 0).toString(16), data: []});
            if (data.success) {
                for (var i = 0; i < data.message.length; i++) {
                    var tempDate = new Date(data.message[i].date),
                            locale = "fr-fr",
                            month = tempDate.toLocaleString(locale, {month: "long"});
                    labelCommandeClient.push(month + " " + tempDate.getFullYear());
                    listData[0].data.push(data.message[i].value);
                }
                clearCommandeClient();
                initCommandeClient(labelCommandeClient, listData);
            }
        },
        error: function (xhr) {
            console.log(xhr);
        }
    });
}
getCommandeClient();
function containsObject(obj, list) {
    var x;
    for (x in list) {
        if (list.hasOwnProperty(x) && list[x] === obj) {
            return true;
        }
    }

    return false;
}
function clearCommandeClient() {
    $('#'+chartCommandeClient).remove(); // this is my <canvas> element
    $('#'+pannelCommandeClient).append('<canvas id="'+chartCommandeClient+'" width="800" height="450"></canvas>');
}


