<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Twang Analytics</title>
        <link rel="stylesheet" type="text/css" href="./css/datepicker.css">
		<link rel="stylesheet" type="text/css" href="./css/bootstrap.css">
</head>
<body>
<div class="container page_content">
	    <div id="main-container" class="container">
			<h2>Twang Analytics</h2>
			<form class="form-track" id="twangAnalytics" name="twangAnalytics" 
				enctype="multipart/form-data" data-validate="parsley">
				<table class="table table-bordered">
				    <tr>
					<td>
					    <label for="name" class="control-label">
					    <p class="text-info">Report</p>
					    </label>
					</td>
					<td>
					    <select class="form-control span3" name=reportdataitem>
						<optgroup label="reportdata">
							<option>Select Report</option>
							<option>OPS Search Keyword Report</option>
							<option>OPS Search Performance Report</option>
							<option>OPS New Release Report</option>
							<option>OPS Popular Report</option>
							<option>OPS Artists Report</option>
							<option>OPS Moods Report</option>
							<option>Ops genre report</option>
							<option>CP Ingestion Report</option>
							<option>CP Performance Report</option>
							<option>Overall Revenue Report</option>
							<option>APP User Acquisition Report</option>
							<option>APP Session Duration Report</option>
							<option>APP User Engagement Report</option>
							<option>APP User Behaviour Report</option>
							<option>APP Event Detail Report</option>
							<option>APP User Loyalty Report</option>
							<option>APP User Recency Report</option>
							<option>APP Exception Report</option>
							<option>DAILY User Retention Report</option>
							<option>User MNP report</option>
							<option>User data plans report</option>
							<option>User payment report</option>
						</optgroup>
					    </select>
					</td>
				    </tr>
				    <tr>
					<td>
					    <label for="name" class="control-label"><p
							class="text-info">Start Date</p></label>
					</td>
					<td>
					    <input type="text" class="datepicker" placeholder="Click me!">
					</td>
				    </tr>
				    <tr>
					<td>
					    <label for="name" class="control-label"><p
							class="text-info">End Date</p></label>
					</td>
					<td>
					    <input type="text" class="datepicker" placeholder="Click me!">
					</td>
				    </tr>
				    <tr >	
					    <td colspan="4" style="text-align: right">
						    <button class="btn btn-primary btn-info">Save n Download</button>
						    <span id="twangAnalyticsResult" name="twangAnalyticsResult"></span>
					    </td>
				    </tr>	
				</table>
        <script type="text/javascript" src="./js/jquery.js"></script>
        <script type="text/javascript" src="./js/bootstrap-datepicker.js"></script>
        <script type="text/javascript" src="./js/bootstrap.js"></script>
	  <script type="text/javascript">
		$(".datepicker").datepicker({
		    format: "dd MM yyyy",
		    autoclose: true,
		});
	    </script>  
    </body>
</body>
</html>