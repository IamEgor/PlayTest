name := "final"

version := "1.0"

lazy val `final` = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.11.1"

libraryDependencies ++= Seq( javaJdbc ,javaEbean, cache , javaWs, "org.postgresql" % "postgresql" % "9.3-1100-jdbc4" )

unmanagedResourceDirectories in Test <+=  baseDirectory ( _ /"target/web/public/test" )  