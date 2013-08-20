lift3_foundation4_template
==========================

An updated Lift starter template using:

* [Lift][1] 3.0-SNAPSHOT (lift\_blank, Scala 2.10)
* [Foundation 4 (SASS)][2]
* [Compass][3] SASS compiler via the SBT plugin [sbt-resources-management][4]
* Elements of [HTML5Boilerplate][5]

You must have [Compass][3] installed and available from the commandline.

## Install

1.  When first cloning this repository, run the included [`submodule-install.sh`][7] script 
to [fetch][6] Foundation and HTML5 Boilerplate submodules.  
2.  `./sbt`
3.  `resources:compile-sass` compiles the following:
    * src/main/resources/styles/sass/foundation/normalize.scss -> src/main/webapp/styles/sass/foundation/normalize.css
    * src/main/resources/styles/sass/foundation/foundation.scss -> src/main/webapp/styles/sass/foundation/foundation.css
    * src/main/resources/styles/sass/main.scss -> src/main/webapp/styles/sass/main.css
4.  Move the compiled css files to src/main/webapp/styles or elsewhere if you prefer to 
serve from a different location than the compile target.
5.  Javascript/Coffeescript compile is not working yet, so manually copy the following:
    * src/main/resources/styles/sass/foundation/js/\* -> src/main/webapp/scripts/vendor/\*
    * src/main/resources/scripts/js/\* -> src/main/webapp/scripts/\*
6.  Check `webapp/templates-hidden/default.html` to make sure all script and style 
links are correct.  Check both top and bottom of page.
7.  `container:start`, open http://localhost:8080

[1]:    http://liftweb.net/
[2]:    http://foundation.zurb.com/  
[3]:    http://compass-style.org/ 
[4]:    https://github.com/Shadowfiend/sbt-resource-management    
[5]:    http://html5boilerplate.com/
[6]:    http://git-scm.com/book/en/Git-Tools-Submodules
[7]:    https://github.com/repos-lift/lift3-foundation4-template/blob/master/submodules-install.sh
