import sbt._

object Plugins extends Build {
  lazy val root              = Project("plugins", file(".")) dependsOn(resourcesPlugin)
  lazy val resourcesPlugin   = uri("git://github.com/Shadowfiend/sbt-resource-management.git")
}

