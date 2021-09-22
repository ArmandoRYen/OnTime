document.addEventListener("DOMContentLoaded", function (event) {

    const showNavbar = (toggleId, navId, bodyId, headerId) => {
      const toggle = document.getElementById(toggleId),
        nav = document.getElementById(navId),
        bodypd = document.getElementById(bodyId),
        headerpd = document.getElementById(headerId)

      // Validate that all variables exist
      if (toggle && nav && bodypd && headerpd) {
        toggle.addEventListener('click', () => {
          // show navbar
          nav.classList.toggle('show')
          // change icon
          toggle.classList.toggle('bx-x')
          // add padding to body
          bodypd.classList.toggle('body-pd')
          // add padding to header
          headerpd.classList.toggle('body-pd')
        })
      }
    }

    showNavbar('header-toggle', 'nav-bar', 'body-pd', 'header')

    /*===== LINK ACTIVE =====*/
    const linkColor = document.querySelectorAll('.nav_link')

    function colorLink() {
      if (linkColor) {
        linkColor.forEach(l => l.classList.remove('active'))
        this.classList.add('active')
      }
    }
    linkColor.forEach(l => l.addEventListener('click', colorLink))

    // Your code to run since DOM is loaded and ready
  })
  
  
  //
  

/*===== 
google.charts.load('current', {packages: ['corechart', 'bar']});
google.charts.setOnLoadCallback(drawBasic);

function drawBasic() {

       var data = google.visualization.arrayToDataTable([
         ['TipoEvento', 'Cantidad', { role: 'style' }],
         ['Ingles', 1, '#b87333'],            // RGB value
         ['FAE', 10, 'silver'],            // English color name
         ['Progra', 5, 'gold'],
         ['Redes', 21, 'color: #e5e4e2' ], // CSS-style declaration
      ]);
      
    var view = new google.visualization.DataView(data);
      view.setColumns([0, 1,
                       { calc: "stringify",
                         sourceColumn: 1,
                         type: "string",
                         role: "annotation" },
                       2]);
                       
      var options = {
      	width: 700,
        title: 'Numero de eventos',
        legend: { position: 'none' },
          bar: { groupWidth: "50%" },
        hAxis: {
          title: 'Eventos',
                   gridlines: {
          color: 'transparent'
          },
         	textPosition: 'none',     
    }  
      };

      var chart = new google.visualization.BarChart(document.getElementById('chart_div'));

      chart.draw(view, options);
    }
=====*/