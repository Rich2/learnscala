version := "0.0.5"
scalaVersion := "2.13.3"
scalaSource := baseDirectory.value / "src" 
Compile/unmanagedSourceDirectories := List(scalaSource.value, baseDirectory.value / "srcApp")
Compile/mainClass := Some("learn.MyApp")
libraryDependencies += "org.openjfx" % "javafx-controls" % "13"