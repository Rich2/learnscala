version := "0.1.1snap"
scalaVersion := "2.13.3"
scalaSource := baseDirectory.value / "src" 
Compile/unmanagedSourceDirectories := List(scalaSource.value, baseDirectory.value / "srcApp")
Compile/mainClass := Some("learn.MyApp")
libraryDependencies += "org.openjfx" % "javafx-controls" % "14"