const width_threshold = 480;


//活动客户流量
function drawLineChart(linetitle,newlabels,newdatesets,linename) {
  if ($("#"+linename+"").length) {
    ctxLine = document.getElementById(linename).getContext("2d");
    optionsLine = {
      scales: {
        yAxes: [
          {
            scaleLabel: {
              display: true,
              labelString:linetitle
            }
          }
        ]
      }
    };
    // Set aspect ratio based on window width
    optionsLine.maintainAspectRatio =
      $(window).width() < width_threshold ? false : true;

    configLine = {
      type: "line",
      data: {
        labels:newlabels,
        datasets:newdatesets
      },
      options: optionsLine
    };

    lineChart = new Chart(ctxLine, configLine);
  }
}

//活动数据统计
function drawBarChart(bartitle,newlables,newdatasets,barname) {
  if ($("#"+barname+"").length) {
    ctxBar = document.getElementById(barname).getContext("2d");
    optionsBar = {
      responsive: true,
      scales: {
        yAxes: [
          {
            barPercentage: 0.2,
            ticks: {
              beginAtZero: true
            },
            scaleLabel: {
              display: true,
              labelString: bartitle
            }
          }
        ]
      }
    };

    optionsBar.maintainAspectRatio =
      $(window).width() < width_threshold ? false : true;

    /**
     * COLOR CODES
     * Red: #F7604D
     * Aqua: #4ED6B8
     * Green: #A8D582
     * Yellow: #D7D768
     * Purple: #9D66CC
     * Orange: #DB9C3F
     * Blue: #3889FC
     */
    configBar = {
      type: "horizontalBar",
      data: {
        labels:newlables,
        datasets:newdatasets
      },
      options: optionsBar
    };

    barChart = new Chart(ctxBar, configBar);
  }
}

function drawPieChart(newlables,newdatasets,piechart,piecontainer) {
  if ($("#"+piechart+"").length) {
    var chartHeight = 300;
    $("#"+piecontainer+"").css("height", chartHeight + "px");

    ctxPie = document.getElementById(piechart).getContext("2d");

    optionsPie = {
      responsive: true,
      maintainAspectRatio: false,
      layout: {
        padding: {
          left: 10,
          right: 10,
          top: 10,
          bottom: 10
        }
      },
      legend: {
        position: "top"
      }
    };

    configPie = {
      type: "pie",
      data: {
        datasets:newdatasets,
        labels:newlables
      },
      options: optionsPie
    };

    pieChart = new Chart(ctxPie, configPie);
  }
}

function updateLineChart() {
  if (lineChart) {
    lineChart.options = optionsLine;
    lineChart.update();
  }
}

function updateBarChart() {
  if (barChart) {
    barChart.options = optionsBar;
    barChart.update();
  }
}
