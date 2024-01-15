Setting product update announcement
=======================

This guide lists the steps required to use SSID's product update announcements. This feature might be used to announce new feature releases or updates for greater feature awareness and discovery.

The product update message appears on the Home tab of SSID after the user logs in as in the following figure:

![Product update announcement](https://user-images.githubusercontent.com/29513997/208039798-c23b8df5-b98e-45e6-a979-8255b3946a6b.png)

The product update message can be set using the rake task 
`rake SSID:set_product_update_message[message]`.

You can toggle the visibility of the message using the following rake tasks:
- `rake SSID:set_product_update_visibility['Y']` for making the message visible.
- `rake SSID:set_product_update_visibility['N']` for making the message invisible.

The commands should be appropriately adapted based on your local setup. For instance, you might need to prepend it with `bundle exec` or use escape characters for symbols e.g. `bundle exec rake SSID:set_product_update_message\["Now you can print reports with multiple student pairs\!"\]`).

On production, prepend the commands with `RACK_ENV=production`. e.g. `RACK_ENV=production bundle exec rails SSID:set_product_update_visibility['N']`

Refer to this video demo for usage example: 
[https://youtu.be/DtyGSvB5m-U](https://youtu.be/DtyGSvB5m-U)