plugins {
	/*
	  Lets Gradle download the JDK pinned by `java.version` when a contributor doesn't
	  have that exact version installed. Toolchains match on the exact major version,
	  so a newer JDK does not satisfy the requirement.
	*/
	id("org.gradle.toolchains.foojay-resolver-convention") version "1.0.0"
}

/*
  This is the name of our MockBukkit artifact, it includes
  the API version of Minecraft we are targeting.
  Valkn: lowercase, as the published artifact (mockbukkit-v26.3), so that a Gradle composite
  build substitutes it for the dependency without any declaration.
*/
rootProject.name = "mockbukkit-v${extensions.extraProperties.get("paper.api.version")}"

include(":extra:TestPlugin")
include(":metaminer")
