/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var labelCasseDate = [];
var chart = 'casse-chart';
var pannelChartName = 'casse-chart-panel';
var casse = document.getElementById(chart).getContext('2d');
var casse = null;
function initChartCasse(label, data) {
    casse = new Chart(document.getElementById(chart), {
        type: 'bar',
        data: {
            labels: label,
            datasets: data
        },
        options: {
            title: {
                display: true,
                text: 'Statistique des articles cass\xE9s'
            }
        }
    });
}
function getCasse() {
    debut = document.getElementById("debut-casse").value;
    fin = document.getElementById("fin-casse").value;
    labelCasseDate = [];
    $.ajax({
        url: "evenementiel/webservice/articleCasse",
        type: "get", //send it through get method
        data: {
            debut: debut,
            fin: fin
        },
        success: function (data) {
            if (data.success) {
                for (var i = 0; i < data.message.length; i++) {
                    var tempDate = new Date(data.message[i][0].date),
                            locale = "fr-fr",
                            month = tempDate.toLocaleString(locale, {month: "long"});
                    labelCasseDate.push(month + " " + tempDate.getFullYear());
                }
                var firstDSize = data.message.length;
                var listArticle = [];
                for (var i = 0; i < firstDSize; i++) {
                    var secondDSize = data.message[i].length;
                    for (var j = 0; j < secondDSize; j++) {
                        var otherTemp = data.message[i][j].other;
                        if (otherTemp !== null) {
                            if (!containsObject(otherTemp.designation, listArticle)) {
                                listArticle.push(otherTemp.designation);
                            }
                        }
                    }
                }
                var listData = [];
                var articleSize = listArticle.length;
                for (var i = 0; i < articleSize; i++) {
                    listData.push({label: listArticle[i], backgroundColor: '#' + (Math.random() * 0xFFFFFF << 0).toString(16), data: []});
                }
                for (var i = 0; i < firstDSize; i++) {
                    var secondDSize = data.message[i].length;
                    var listArticleTemp = data.message[i];
                    var listDataSize = listData.length;
                    for (var j = 0; j < listDataSize; j++) {
                        var article = listData[j].label;
                        var otherTemp = data.message[i][0].other;
                        if (otherTemp === null) {
                            listData[j].data.push(0);
                        } else {
                            var index = listArticleTemp.findIndex(x => x.other.designation === article);
                            if (index < 0) {
                                listData[j].data.push(0);
                            } else {
                                listData[j].data.push(data.message[i][index].value);
                            }
                        }
                    }

                }
                clearCasse();
                initChartCasse(labelCasseDate, listData);
            }
        },
        error: function (xhr) {
            console.log(xhr);
        }
    });
}
getCasse();
function containsObject(obj, list) {
    var x;
    for (x in list) {
        if (list.hasOwnProperty(x) && list[x] === obj) {
            return true;
        }
    }

    return false;
}
function clearCasse() {
    $('#'+chart).remove(); // this is my <canvas> element
    $('#'+pannelChartName).append('<canvas id="'+chart+'" width="800" height="450"></canvas>');
}
        

