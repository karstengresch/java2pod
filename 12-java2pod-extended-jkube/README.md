Reference project for an article at Open Sourcerers: https://www.opensourcerers.org/2023/06/05/java-to-pod/

## Commands, as mentioned there

### Build Image
```bash
# Replace “gresch” with >>>your<<<>>> registry username!
mvn k8s:build -Djkube.build.strategy=jib -Djkube.generator.name="quay.io/gresch/%a:%l"
```

### Push Image
```bash
# Replace “gresch” with >>>your<<<>>> registry username!
mvn k8s:push -Djkube.generator.name="quay.io/gresch/%a:%l"
```

###
```bash
# Replace “gresch” with >>>your<<<>>> registry username!
# Adjust ‘jkube.domain’!
mvn k8s:resource k8s:apply -Djkube.generator.name="quay.io/gresch/%a:%l" -Djkube.namespace=j2p-jkube -Djkube.createExternalUrls=true -Djkube.domain=apps.ocp4.devworkshop.cc
```

## Notes to Some Settings

`jkube.generator.name=”quay.io/<user-/orgname>/%a:%l”`
<br />Specifies the image URL (incl. tag) at the external repository.

`me=”quay.io/<user-/orgname>/%a:%l”`
<br />Specifies the image URL (incl. tag) at the external repository.

`jkube.namespace=<K8s namespace>`
<br />The namespace on the K8s cluster

`jkube.createExternalUrls=true`
<br />Automatically creates the Ingress routes.

`jkube.domain=mydomain.mytld`
<br />The external URL under which your application shall be available

## Placeholder	Descriptions
%g
<br />
The last part of the Maven group name, sanitized so that it can be used as username on GitHub. Only the part after the last dot is used. E.g. for a group id org.eclipse.jkube this placeholder would insert jkube

%a
<br />
A sanitized version of the artefact id so that it can be used as part of an Docker image name. I.e. it is converted to all lower case (as required by Docker)

%v
<br />
The project version. Synonym to ${project.version}

%l
<br />
If the project version ends with -SNAPSHOT then this placeholder is latest, otherwise its the full version (same as %v)

%t
<br />
If the project version ends with -SNAPSHOT this placeholder resolves to snapshot-<timestamp> where timestamp has the date format yyMMdd-HHmmss-SSSS (eg snapshot-). This feature is especially useful during development in oder to avoid conflicts when images are to be updated which are still in use. You need to take care yourself of cleaning up old images afterwards, though.


Full documentation here: https://eclipse.dev/jkube/docs (there select flavor: Maven/Gradle, K8s/OpenShift).
