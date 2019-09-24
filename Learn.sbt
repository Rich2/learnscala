scalaVersion := "2.13.1"
scalaSource := baseDirectory.value / "src" 
Compile/unmanagedSourceDirectories := List(scalaSource.value, baseDirectory.value / "srcApp")
Compile/mainClass := Some("learn.MyApp")