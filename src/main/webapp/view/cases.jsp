<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width,initial-scale=1.0">
<meta charset="ISO-8859-1">
<link href="/css/Cases.css" rel="stylesheet"/>
<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Roboto&display=swap" rel="stylesheet">
<title>UK Covid-19 Cases</title>

	<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script type="text/javascript">
      google.charts.load('current', {'packages':['corechart']});
      google.charts.setOnLoadCallback(drawChart);

      function drawChart() {    	  
    	  
        var data = google.visualization.arrayToDataTable(        		       	        		
        		
        		${formattedGoogleArray}
        		
          );

        var options = {
          title: 'Confirmed Cases',
          curveType: 'function',
          legend: 'none',
          colors: ['red'],
          'backgroundColor': 'fffff0',
        };

        var chart = new google.visualization.LineChart(document.getElementById('curve_chart'));

        
        chart.draw(data, options);
        
      }
      
    </script>

</head>
<body>

<div class="header">
	<p>Consuming Covid-19 API</p>
</div>

<div class="main-container">

	<div class="total-cases-container">
		<p class="total-cases-container__title">Total Confirmed UK</p>
		<p class="total-cases-container__cases">${strTotalCases}</p>
		<p class="total-cases-container__date">Last updated: ${strLatestDate}</p>
	</div>
	
	<div class="graph-wrapper">
		<div id="curve_chart" class="cases-graph"></div>
	</div>
	
</div>

</body>
</html>