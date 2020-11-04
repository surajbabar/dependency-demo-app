# dependency-demo-app
Demo project to show different ways of fixing vulnerabilities found in Maven based java project.


- Run Dependency check with following Command

    ```mvn org.owasp:dependency-check-maven:check```

    The result will be generated at **target/dependency-check-report.html**

- Different kinds of vulnerabilities and ways to fix them


| Vulnerability Category | Vulnerable dependency | CVE Number| How to Fix  |
| :-------------: |:-------------:| :-----:| :-----:|
|Upgrade Possible | guava-18.0.jar| [CVE-2018-10237](https://nvd.nist.gov/vuln/detail/CVE-2018-10237)|Upgrade to guava-29.0-jre.jar |
|Gaurd Clause/Code Change | jackson-databind-2.8.7.jar| [CVE-2017-15095](https://nvd.nist.gov/vuln/detail/CVE-2017-15095)  | Disable default type conversion|
|Unused Vulnerable library  | hibernate-validator-5.3.5.Final.jar | [CVE-2017-7536](https://nvd.nist.gov/vuln/detail/CVE-2017-7536)  | Exclude the dependency |
|Unused Vulnerable feature | quartz-2.0.1.jar | [CVE-2019-13990](https://nvd.nist.gov/vuln/detail/CVE-2019-13990) | Review and supress |
