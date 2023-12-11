# jar build by maven-shade-plugin fails
```shell
mvn clean install
java -jar target/executable-demo-1.0.0-SNAPSHOT-jar-with-dependencies.jar 
```

# error message
```text
$ java -jar target/executable-demo-1.0.0-SNAPSHOT-jar-with-dependencies.jar 
SLF4J: No SLF4J providers were found.
SLF4J: Defaulting to no-operation (NOP) logger implementation
SLF4J: See https://www.slf4j.org/codes.html#noProviders for further details.
Exception in thread "main" java.util.MissingResourceException: The string resource '_UI_DiagnosticRoot_diagnostic' could not be located
        at org.eclipse.emf.common.util.DelegatingResourceLocator.delegatedGetString(DelegatingResourceLocator.java:578)
        at org.eclipse.emf.common.util.DelegatingResourceLocator.getString(DelegatingResourceLocator.java:450)
        at org.eclipse.emf.common.util.DelegatingResourceLocator.getString(DelegatingResourceLocator.java:597)
        at org.eclipse.emf.common.util.DelegatingResourceLocator.getString(DelegatingResourceLocator.java:589)
        at org.eclipse.emf.ecore.util.Diagnostician.createDefaultDiagnostic(Diagnostician.java:110)
        at org.eclipse.emf.ecore.util.Diagnostician.validate(Diagnostician.java:129)
        at io.sapl.interpreter.DefaultSAPLInterpreter.parse(DefaultSAPLInterpreter.java:71)
        at io.sapl.interpreter.DefaultSAPLInterpreter.parse(DefaultSAPLInterpreter.java:65)
        at io.sapl.prp.filesystem.ImmutableFileIndex$Document.<init>(ImmutableFileIndex.java:271)
        at io.sapl.prp.filesystem.ImmutableFileIndex.load(ImmutableFileIndex.java:176)
        at io.sapl.prp.filesystem.ImmutableFileIndex.<init>(ImmutableFileIndex.java:77)
        at io.sapl.prp.filesystem.FileSystemPrpUpdateEventSource.getUpdates(FileSystemPrpUpdateEventSource.java:57)
        at io.sapl.prp.GenericInMemoryIndexedPolicyRetrievalPoint.<init>(GenericInMemoryIndexedPolicyRetrievalPoint.java:35)
        at io.sapl.pdp.PolicyDecisionPointFactory.constructFilesystemPolicyRetrievalPoint(PolicyDecisionPointFactory.java:174)
        at io.sapl.pdp.PolicyDecisionPointFactory.filesystemPolicyDecisionPoint(PolicyDecisionPointFactory.java:96)
        at io.sapl.pdp.PolicyDecisionPointFactory.filesystemPolicyDecisionPoint(PolicyDecisionPointFactory.java:83)
        at io.sapl.pdp.PolicyDecisionPointFactory.filesystemPolicyDecisionPoint(PolicyDecisionPointFactory.java:69)
        at io.sapl.demo.Main.main(Main.java:11)
```

# jar build by maven-shade-plugin okay
Exclude plugin.properties from eclipse dependencies and replace with manual file containing _UI_DiagnosticRoot_diagnostic
```shell
java -jar target/executable-demo-1.0.0-SNAPSHOT.jar 
```