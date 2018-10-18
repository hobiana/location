/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var labelBenificeClient = [];
var chart = 'benifice-client';
var pannelChartName = 'panel-benifice-client';
var benificeClient = document.getElementById(chart).getContext('2d');
var benificeClient = null;
function initBenificeClient(label, data) {
    
    benificeClient = new Chart(document.getElementById(chart), {
        type: 'bar',
        data: {
            labels: label,
            datasets: data
        },
        options: {
            title: {
                display: true,
                text: 'Statistique des d\xE9penses du client mensuel (en Ar)'
            }
        }
    });
}
function getBenificeClient() {
    debut = document.getElementById("debut-benifice").value;
    fin = document.getElementById("fin-benifice").value;
    labelBenificeClient = [];
    var urlParams = new URLSearchParams(location.search);
    var idClient = +urlParams.getAll('idClient');
    $.ajax({
        url: "evenementiel/webservice/getBenificeClient",
        type: "get", //send it through get method
        data: {
            debut: debut,
            fin: fin,
            idClient: idClient
        },
        success: function (data) {
            
            var listData = [];
            listData.push({label: 'D\xE9pense', backgroundColor: '#' + (Math.random() * 0xFFFFFF << 0).toString(16), data: []});
            if (data.success) {
                for (var i = 0; i < data.message.length; i++) {
                    var tempDate = new Date(data.message[i].date),
                            locale = "fr-fr",
                            month = tempDate.toLocaleString(locale, {month: "long"});
                    labelBenificeClient.push(month + " " + tempDate.getFullYear());
                    listData[0].data.push(data.message[i].value);
                }
                clearBenificeClient();
                initBenificeClient(labelBenificeClient, listData);
            }
        },
        error: function (xhr) {
            console.log(xhr);
        }
    });
}
getBenificeClient();
function containsObject(obj, list) {
    var x;
    for (x in list) {
        if (list.hasOwnProperty(x) && list[x] === obj) {
            return true;
        }
    }

    return false;
}
function clearBenificeClient() {
    $('#'+chart).remove(); // this is my <canvas> element
    $('#'+pannelChartName).append('<canvas id="'+chart+'" width="800" height="450"></canvas>');
}

