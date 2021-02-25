# AndroidAerial
A 4k Video Android TV Screensaver

# -THIS PROJECT-

I am not a developer, I have no experience, skill or ability in this space whatsoever. I am however very frustrated by what seems like a simple problem without a solution: "Play 4k videos from a local folder as a screensaver on Android TV". I decided to put my money where my mouth is and commission a bare bones app to do just that. AndroidAerial is probably as far from perfect as it's possible to be but it does just about work. I have reached the limit of what I can/will pay for development so I decided to dump everything on Github to see if anyone more competent than me is interested in taking over. 

PS. I also dont really know anything about Github so apologies for the mess that is this repo. Just keep in mind that I know nothing.

--------


# -BACKGROUND-

I've long coveted the Aerial videos screensaver on the Apple TV. There are options to mimic this on Android TV, but they both have their problems. I wanted an app that would allow me to download the publicly accessable Apple Screensaver video files, drop them on my Nvidia Shield and have them play in a randomised loop.

--------

# -CURRENT OPTIONS-

Option 1
<a href="https://play.google.com/store/apps/details?id=com.codingbuffalo.aerialdream&hl=en_GB&gl=US" target="_blank">Aerial Dream</a>

This is certainly the most polished Android option out there, FAR more polished that this BETA. It's key problem is that there is no support for Local files or Offline Caching meaning whenever your screensaver is active there are huge files being streamed over the internet.

Option 2
<a href="https://play.google.com/store/apps/details?id=com.furnaghan.android.photoscreensaver&hl=en_GB&gl=US" target="_blank">Photo Gallery and Screensaver</a>

I believe this app is basically abandonware, there hasn't been an update since Dec 2019 and the dev is totally non-responsive. It does have local video support but the implementation is very clunky. Support for 4k Videos is also extremely limited and despite much experimenting I haven't been able to find a way to get it to play smoothly and reliably.

--------

# -HOW TO USE-

The app is very limited in it's functionality. It will only play ".mov" files and it will only scan a single fixed local folder. It has also only been tested on a 2019 Nvidia shield.

1. Install the APK on your Android TV.
2. Create the following folder: "Storage/emulated/0/Screensaver"
3. Launch the app and grant it permission to access your filesystem.
4. Put any .mov videos into that folder to include them in the screensaver.
5. Select AndroidAerial from screensaver settings.

All the Apple aerial videos are publicly available to download and can be accessed via the urls in this document

https://docs.google.com/spreadsheets/d/1bboTohF06r-fafrImTExAPqM9m6h2m2lgJyAkQuYVJI/edit#gid=1684411812

--------

# -ISSUES-

- Not possible to manually select source folder
- Any non-video files in the folder seem to break the screensaver
- If other media is paused, screensaver will fail to launch.
