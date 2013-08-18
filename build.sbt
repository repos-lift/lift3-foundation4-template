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

// AWS keys currently required even if not using them, will change in upcoming version
// https://github.com/Shadowfiend/sbt-resource-management/issues/8
awsAccessKey := "YOUR_ACCESS_KEY"

awsSecretKey := "YOUR_SECRET_KEY"

awsS3Bucket  := "YOUR_S3_BUCKET"

seq(resourceManagementSettings :_*)

//styleDirectories in ResourceCompile := Seq(file("src/main/webapp/*/styles")) // default
styleDirectories in ResourceCompile := Seq(file("src/main/resources/styles/sass/*.scss"))

//scriptDirectories in ResourceCompile := Seq(file("src/main/webapp/*/scripts")) // default
scriptDirectories in ResourceCompile := Seq(file("src/main/resources/*/*.js"))

//coffeeScriptSources in ResourceCompile := Seq(file("src/main/webapp/**/*.coffee")) // default
coffeeScriptSources in ResourceCompile := Seq(file("src/main/resources/*/*.coffee"))

//targetJavaScriptDirectory in ResourceCompile := file("target/scripts") // default
targetJavaScriptDirectory in ResourceCompile := file("src/main/webapp/scripts/vendor")

//compiledCoffeeScriptDirectory in ResourceCompile := file("target/compiled-coffee-script") // default
compiledCoffeeScriptDirectory in ResourceCompile := file("src/main/webapp/scripts")

//compressedTarget in ResourceCompile := file("target/compressed") // default
compressedTarget in ResourceCompile := file("src/main/webapp/scripts/bin")
