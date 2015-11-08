 <script>
    window.fbAsyncInit = function() {
        FB.init({
          appId      : '1685693118318634',
          xfbml      : true,
          version    : 'v2.5'
        });
      };

    (function(d, s, id){
        var js, fjs = d.getElementsByTagName(s)[0];
        if (d.getElementById(id)) {return;}
        js = d.createElement(s); js.id = id;
        js.src = "//connect.facebook.net/en_US/sdk.js";
        fjs.parentNode.insertBefore(js, fjs);
    }(document, 'script', 'facebook-jssdk'));

    function share(dateRateId, username, description) {
        FB.ui(
            {
                method: 'feed',
                link: 'http://idaterate.com/viewdaterate?id=' + dateRateId,
				caption: 'iDateRate.com',
				name: username + ' was Date Rated',
				description: description
            }, function(response){});
    }
</script>