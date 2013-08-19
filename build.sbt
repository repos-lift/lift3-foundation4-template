name := "Lift 3.0 with Foundation 4 template"

version := "0.0.1"

organization := "net.liftweb"

scalaVersion := "2.10.1"

resolvers ++= Seq(
  "Java.net Maven2 Repository"     at "http://download.java.net/maven/2/",
  "Sonatype scala-tools repo"      at "https://oss.sonatype.org/content/groups/scala-tools/",
  "Sonatype scala-tools releases"  at "https://oss.sonatype.org/content/repositories/releases",
  "Sonatype scala-tools snapshots" at "https://oss.sonatype.org/content/repositories/snapshots"
)

seq(com.github.siasia.WebPlugin.webSettings :_*)

unmanagedResourceDirectories in Test <+= (baseDirectory) { _ / "src/main/webapp" }

scalacOptions ++= Seq("-deprecation", "-unchecked")

libraryDependencies ++= {
  val liftVersion = "3.0-SNAPSHOT"
  Seq(
    "net.liftweb"             %% "lift-webkit"       % liftVersion             % "compile",
    "net.liftweb"             %% "lift-mapper"       % liftVersion             % "compile",
    "ch.qos.logback"          %  "logback-classic"   % "1.0.6",
    "junit"                   %  "junit"             % "4.7"                   % "test",
    "org.specs2"              %% "specs2"            % "1.14"                  % "test",
    "org.scalatest"           %% "scalatest"         % "2.0.M5b"               % "test",
    "org.eclipse.jetty"       %  "jetty-webapp"      % "8.1.7.v20120910"       %  "container,compile",
    "org.eclipse.jetty.orbit" %  "javax.servlet"     % "3.0.0.v201112011016"   %  "container,compile" artifacts Artifact("javax.servlet", "jar", "jar"),
    "net.liftmodules"         %% "mapperauth_2.5"    % "0.1-SNAPSHOT"          %  "compile" intransitive(),
    "net.liftmodules"         %% "extras_2.5"        % "0.1"                   %  "compile" intransitive(),
    "com.h2database"          %  "h2"                % "1.2.138",
    "net.databinder.dispatch" %% "dispatch-core"     % "0.10.0"
  )
}

//-- sbt-managed-resources plugin config (SASS, etc) --\\

// The following four lines not required for resources:compile-sass, but are required for 
// resources:copy-scripts and other deploy related commands.
// https://github.com/Shadowfiend/sbt-resource-management/pull/17
awsAccessKey := "YOUR_ACCESS_KEY"

awsSecretKey := "YOUR_SECRET_KEY"

awsS3Bucket  := "YOUR_S3_BUCKET"

seq(resourceManagementSettings :_*)

//source directory for SASS
//styleDirectories in ResourceCompile := Seq(file("src/main/webapp/*/styles")) // default
styleDirectories in ResourceCompile := Seq(file("src/main/resources/styles/sass/*.scss"))

//source directory for JavaScripts
//scriptDirectories in ResourceCompile := Seq(file("src/main/webapp/*/scripts")) // default
scriptDirectories in ResourceCompile := Seq(file("src/main/resources/*/*.js"))

//source directory for CoffeeScripts
//coffeeScriptSources in ResourceCompile := Seq(file("src/main/webapp/**/*.coffee")) // default
coffeeScriptSources in ResourceCompile := Seq(file("src/main/resources/*/*.coffee"))

//target directory for command resources:copy-scripts
//serving directory for all Javascript files (both original source JS and compiled CoffeeScript)
//targetJavaScriptDirectory in ResourceCompile := file("target/scripts") // default
targetJavaScriptDirectory in ResourceCompile := file("src/main/webapp/scripts")

//target directory for command resources:compile-coffee-script
//compiledCoffeeScriptDirectory in ResourceCompile := file("target/compiled-coffee-script") // default
compiledCoffeeScriptDirectory in ResourceCompile := file("src/main/resources/scripts/compiled")

//target directory for command resources:compress-resources; resources:compress-scripts; resources:compress-styles
//compressedTarget in ResourceCompile := file("target/compressed") // default
compressedTarget in ResourceCompile := file("src/main/resources/scripts/compressed")
