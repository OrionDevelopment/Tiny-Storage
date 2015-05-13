@echo off

if %1 == dev (
    gradlew -q setDevVersion
) else ( if %1 == patch (
    gradlew -q incrementPatch
    ) else ( if %1 == minor (
        gradlew -q incrementMinor
        ) else ( if %1 == major (
            gradlew -q incrementMajor
			else (
                echo Can't detect proper args. Exiting ...
                goto end
            )
        )
    )
)
:end
