# cljs-solutions

[Clojure](http://clojure.org)/[ClojureScript](https://github.com/clojure/clojurescript)
solutions to CodePlus Challenges.

## <center>Overview</center>

In an effort to show how different languages can be used to stimulate
new, outside-the-box ideas and approaches to creating software, I
hereby offer my Clojure and ClojureScript solutions to the problems
found in the parent directory.

Most of the code here is both Clojure and ClojureScript. For example, every file
with the `.cljc` extension may be compiled by both, with necessary exceptions
delineated by the `#?` or `#?@` [reader conditionals](http://clojure.org/reference/reader#_reader_conditionals).
Files with the `.clj` extension are just for Clojure, while `.cljs` are
ClojureScript files.

To play with the code, you'll probably need to have [Leiningen](http://leiningen.org)
installed. On the Mac, I recommend installing via [Homebrew](http://brew.sh), as
in `brew update; brew install lein`. (In fact, if you are on a Mac and just
want to dabble at a ClojureScript REPL, you *won't* need `lein`. Just run the
beautifully self-contained [planck](http://planck-repl.org), which may also be
simply `brew install`ed.) But to run Clojure code — as opposed to ClojureScript —
or to build changes and run tests, you'll need the build environment supported
by `lein`.

— _**Tyler Perkins**, May 2016_

## <center>First, Tests</center>

### Clojure

With [Leiningen](http://leiningen.org) installed, just run the following at the
command line from within the `CodePlusChallenges/cljs-solutions/` directory:

    lein test

This will build all the source and run all tests, located in `test/`.

### ClojureScript

If you have [node](https://nodejs.org/en/) installed, you can run the provided
tests in namespaces specified in file `test/test_runner.cljs`. Just run this at
the command line from `CodePlusChallenges/cljs-solutions/`:

    lein doo node test once

If you're editing files and would like the tests to run automatically when a
file is saved, just leave off the `once` option, above.

Node has no DOM, of course, so if you write some GUI tests requiring the DOM,
take a look at the [doo documentation](https://github.com/bensu/doo).
It can run tests in PhantomJS, Chrome, Safari, Firefox, and more.

## <center>Born to Run!</center>

### Clojure

To play in the Clojure [REPL](https://en.wikipedia.org/wiki/Read–eval–print_loop)
just run the following from `CodePlusChallenges/cljs-solutions/`. As shown,
you'll need to require the namespaces you're interested in and possibly "cd"
into one using `in-ns`:

    > cd cljs-solutions/

    > lein repl    # Patience, this will take a while!
    nREPL server started on port 61997 on host 127.0.0.1 - nrepl://127.0.0.1:61997
    REPL-y 0.3.7, nREPL 0.2.12
    Clojure 1.8.0
    Java HotSpot(TM) 64-Bit Server VM 1.8.0_60-ea-b10
        Docs: (doc function-name-here)
              (find-doc "part-of-name-here")
      Source: (source function-name-here)
     Javadoc: (javadoc java-object-or-class-here)
        Exit: Control+D or (exit) or (quit)
     Results: Stored in vars *1, *2, *3, an exception in *e

    user=> (require 'cljs-solutions.problem_1)
    nil
    user=> (in-ns 'cljs-solutions.problem_1)
    #object[clojure.lang.Namespace 0x7c9551d8 "cljs-solutions.problem_1"]
    cljs-solutions.problem_1=> (shuf [11 22 33 44])
    [22 11 44 33]
    cljs-solutions.problem_1=>

### ClojureScript

#### Planck

As mentioned above, perhaps the simplest way to jump start into a ClojureScript
[REPL](https://en.wikipedia.org/wiki/Read–eval–print_loop) in OS X is to run
[planck](http://planck-repl.org). Note that planck doesn't know anything about
the project, such as where source files are located, but it can search for
namespaces from the current directory:

    > cd src

    > planck       # No patience required. This is fast!
    Planck 1.14
    ClojureScript 1.9.14
        Docs: (doc function-name-here)
              (find-doc "part-of-name-here")
      Source: (source function-name-here)
        Exit: Control+D or :cljs/quit or exit or quit
     Results: Stored in vars *1, *2, *3, an exception in *e

    cljs.user=> (require 'cljs-solutions.problem_1)
    nil
    cljs.user=> (in-ns 'cljs-solutions.problem_1)
    nil
    cljs-solutions.problem_1=> (shuf [11 22 33 44])
    [22 33 44 11]
    cljs-solutions.problem_1=>

Note that unlike when we tested above with `lein doo node ...`, here we are not
executing the compiled JavaScript in Node. Planck employs OS X's JavaScriptCore
framework to execute in the Mac's built-in JS engine.

#### Figwheel

You might expect that we can compile our ClojureScript to JavaScript and run it
in a browser, but with Figwheel, we can develop using a browser-connected REPL.
The solutions here don't make use of it, but Figwheel's killer feature is
amazing: When you modify and save an HTML, CSS, JavaScript, or ClojureScript
file, it is instantly compiled and __*sent to the browser!*__

This can make for a very fluid development workflow as you make changes to the
behavior and appearance of your web app in ClojureScript, and instantly see the
changes as the app runs. With the everpresent REPL, you can poke around in the
running environment, try changing the definition of a function on the fly,
examine the state in the page, etc.

To get an interactive development environment run:

    lein figwheel

and open your browser at [localhost:3449](http://localhost:3449/).
This will auto compile and send all changes to the browser without the
need to reload. After the compilation process is complete, you will
get a Browser Connected REPL. An easy way to try it is:

    (js/alert "Am I connected?")

and you should see an alert in the browser window.

As above, we can try out `shuf` in the REPL. Here I'm using [rlwrap](https://github.com/hanslub42/rlwrap)
to create a better line-editing experience. (It is available on the Mac via
`brew install rlwrap`.)

    > rlwrap lein figwheel
    Figwheel: Validating the configuration found in project.clj

    Figwheel: Configuration Valid. Starting Figwheel ...
    Figwheel: Starting server at http://0.0.0.0:3449
    Figwheel: Watching build - dev
    Compiling "resources/public/js/compiled/cljs_solutions.js" from ["src"]...
    Successfully compiled "resources/public/js/compiled/cljs_solutions.js" in 1.798 seconds.
    Figwheel: Starting CSS Watcher for paths  ["resources/public/css"]
    Launching ClojureScript REPL for build: dev
    Figwheel Controls:
              (stop-autobuild)                ;; stops Figwheel autobuilder
              (start-autobuild [id ...])      ;; starts autobuilder focused on optional ids
              (switch-to-build id ...)        ;; switches autobuilder to different build
              (reset-autobuild)               ;; stops, cleans, and starts autobuilder
              (reload-config)                 ;; reloads build config and resets autobuild
              (build-once [id ...])           ;; builds source one time
              (clean-builds [id ..])          ;; deletes compiled cljs target files
              (print-config [id ...])         ;; prints out build configurations
              (fig-status)                    ;; displays current state of system
      Switch REPL build focus:
              :cljs/quit                      ;; allows you to switch REPL to another build
        Docs: (doc function-name-here)
        Exit: Control+C or :cljs/quit
     Results: Stored in vars *1, *2, *3, *e holds last exception object
    Prompt will show when Figwheel connects to your application
    To quit, type: :cljs/quit
    cljs.user=> (require 'cljs-solutions.problem_1)
    nil
    cljs.user=> (in-ns 'cljs-solutions.problem_1)
    nil
    cljs-solutions.problem_1=> (shuf [11 22 33 44])
    [44 33 22 11]
    cljs-solutions.problem_1=>

To clean all compiled files:

    lein clean

## License

Copyright © 2016

Distributed under the Eclipse Public License either version 1.0 or (at your option) any later version.
