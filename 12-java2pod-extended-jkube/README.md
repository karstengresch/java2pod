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

`jkube.namespace=<K8s namespace>`
<br />The namespace on the K8s cluster

`jkube.createExternalUrls=true`
<br />Automatically creates the Ingress routes.

`jkube.domain=mydomain.mytld`
<br />The external URL under which your application shall be available

## Placeholder Descriptions

%g
<br />
Last part of the Maven group name, sanitized for to be used as username on GitHub. Only part _after last_ dot used. E.g. for a group id org.eclipse.jkube this placeholder would insert jkube

%a
<br />
Sanitized version of the artifact id so that it can be used as part of a container image name. I.e. converted to all lower case (required by Docker).

%v
<br />
Project version. Synonym to ${project.version}

%l
<br />
If the project version ends with -SNAPSHOT then this placeholder is latest, otherwise its the full version (same as %v)

%t
<br />
If the project version ends with -SNAPSHOT this placeholder resolves to snapshot-<timestamp> where timestamp has the date format yyMMdd-HHmmss-SSSS (eg snapshot-). This feature is especially useful during development in oder to avoid conflicts when images are to be updated which are still in use. **Take care yourself of cleaning up old images afterwards!**

Full documentation here: https://eclipse.dev/jkube/docs (there select flavor: Maven/Gradle, K8s/OpenShift).

## Working w/ private OpenShift registry?

See handling here: https://www.opensourcerers.org/2023/06/05/java-to-pod/#openshift-private-registry

Make sure to login w/

```
(docker|podman) login  -u `oc whoami` -p `oc whoami --show-token` <oc-registry-route, e.g. default-route-openshift-image-registry.apps.ocp4.mydomain.mytld
```

first or take care of authentication (see https://eclipse.dev/jkube/docs/openshift-maven-plugin/#authentication)!
