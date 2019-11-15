# RedCrossAction

During the autemn Open Hack 2019 team Mjukisarna has been hacking the [Challenge from Swedish Red Cross.](https://www.luminpdf.com/viewer/5dcf2927a562620019dd83f6)

#### In brief, we've created a base for an automated system for social media monitoring and reports managing. 

### *How it works?*

1)  On a server side our systems monitors media and collects all mentions that might be intrested for the RedCross. For demo purpose, we were collecting all mentions of `Danger`, `terrorist`, `emergency`, `disaster` and  `conflict`. In further versions it can be set up in admin. (*On technical side at the moment we've [reused the open source twitter scrapper](https://github.com/eddiemon/rc-action-backend/tree/master/tweet_scraper) that uses twitter search in order to find twits with the intresting mentions for us. As a plan, other media resources will be connected one by one*)

2) The Android App for Red Cross Volonteers (in this repo) will send push notification "It seems that something is going on in this area! Go check it! "(*we've prepared the base for it but whole solution will be implemented later*) when the threshold of mentions is met (for ex. 10 people in the same area have written about a `conflict`). On the first page a volonteer will see a news feed with picked up news and tweets like here :

<p align="center">
<img width="250" src="https://user-images.githubusercontent.com/25244078/68982327-d4214e80-0806-11ea-93b6-026087f55137.jpg">
</p>


3) The volonteer can go the place and either report "all is calm" or report an incident to the server. Volonteer can select type of event, indicate severity level, probable resources required and any comments the will be sent to the administrator who will send more notifications to other volonteers. 
(*All parts of reporting an incident are available in this repo*)

4) All reported incidents are received in the server ( *During the hackaton our team has implemented a python based rest app and set up a heroku server so that we could test our parts together. This part can be found [here](https://github.com/eddiemon/rc-action-backend)*)

5) All insidents will be shown on the map so that the admin will have a good overview of all incidents and amount of volonteers involved. (*this part is still under development*)

That's it for now. 
To be continued... :)
