<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="springForm"%>
<!DOCTYPE HTML>
<html>
<head>
    <title>iDateRate | QuickPay</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<link href="http://fonts.googleapis.com/css?family=Lato:100" rel="stylesheet" type="text/css"/>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css"/>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css"/>
	<script src="http://code.jquery.com/jquery-1.11.3.min.js"></script>
	
    <script src="https://code.jquery.com/ui/1.10.2/jquery-ui.min.js"></script>
    <script src="js/jquery.caret.min.js"></script>
    <script src="js/jquery.tag-editor.min.js"></script>
        
    <link rel="stylesheet" type="text/css" href="http://ajax.googleapis.com/ajax/libs/jqueryui/1/themes/flick/jquery-ui.css"/>
    <link href="/css/jquery.tag-editor.css" rel="stylesheet" type="text/css"/>

</head>
<body>
    <jsp:include page="layouts/nav.jsp"/>
    <div class="container">
        <h1>Search Username: jojo123</h1>
        <hr/>
        <div class="container">
        	<div class="row">
                <div class="col-md-12">
                    <div class="panel panel-default">
                      <div class="panel-heading">
                        <h3 class="panel-title">Paypal Payment Required</h3>
                      </div>
                      <div class="panel-body text-center">
                        <h4>A paypal payment is required for each username search</h4>

                        <div class="row" style="padding-top:20px">
                            <div class="col-md-4"></div>
                            <div class="col-md-4">
                                <ul class="list-group">
                                  <li class="list-group-item"><span class="glyphicon glyphicon-ok text-success"></span> Single Username Search <span class="pull-right"><u>$4.99</u></span></li>
                                </ul>
                            </div>
                            <div class="col-md-4"></div>
                        </div>

                        <div style="padding-top:20px">
                            <form action="https://www.paypal.com/cgi-bin/webscr" method="post" target="_top">
                            <input type="hidden" name="cmd" value="_xclick">
                            <input type="hidden" name="business" value="info@idaterate.com">
                            <input type="hidden" name="notify_url" value="http://www.idaterate.com/ipn">
                            <input type="hidden" name="lc" value="BM">
                            <input type="hidden" name="item_name" value="Username Search">
                            <input type="hidden" name="item_number" value="1">
                            <input type="hidden" name="amount" value="5.00">
                            <input type="hidden" name="currency_code" value="USD">
                            <input type="hidden" name="button_subtype" value="services">
                            <input type="hidden" name="no_note" value="0">
                            <input type="hidden" name="bn" value="PP-BuyNowBF:btn_buynowCC_LG.gif:NonHostedGuest">
                            <input type="image" src="https://www.paypalobjects.com/en_US/i/btn/btn_buynowCC_LG.gif" border="0" name="submit" alt="PayPal - The safer, easier way to pay online!">
                            <img alt="" border="0" src="https://www.paypalobjects.com/en_US/i/scr/pixel.gif" width="1" height="1">
                            </form>
                        </div>

                        <div>
                            <p class="text-muted small">A payment is required for each username search. This is a single, one time, non refundable payment. You will not be rebilled. You will be redirected to the Username Search Results page after successful payment.</p>
                        </div>
                      </div>
                    </div>
                </div>
            </div> 
        </div>
    </div>
    <script>
    $('#demo1').tagEditor({
        delimiter: ', ', /* space and comma */
        placeholder: '#'
    });
    </script>
    <script src="js/add_date_rate.js"></script>
</body>
</html>