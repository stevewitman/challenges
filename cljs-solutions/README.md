# cljs-solutions

Clojure/ClojureScript solutions to CodePlus Challenges.

## Overview

In an effort to show how different languages can be used to stimulate
new, outside-the-box ideas and approaches to creating software, I
hereby offer my Clojure and ClojureScript solutions to the problems
found in the parent directory.
— _**Tyler Perkins**, May 2016_

## Setup

To get an interactive development environment run:

    lein figwheel

and open your browser at [localhost:3449](http://localhost:3449/).
This will auto compile and send all changes to the browser without the
need to reload. After the compilation process is complete, you will
get a Browser Connected REPL. An easy way to try it is:

    (js/alert "Am I connected?")

and you should see an alert in the browser window.

To clean all compiled files:

    lein clean

To create a production build run:

    lein do clean, cljsbuild once min

And open your browser in `resources/public/index.html`. You will not
get live reloading, nor a REPL. 

## License

Copyright © 2016

Distributed under the Eclipse Public License either version 1.0 or (at your option) any later version.
