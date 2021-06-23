Steps to run the tests

1) Clone the repo.
2) Create maven project from the repo
3) Update the driver version in DriverFactory to match your chrome browser version. See about section of your chrome 
browser. 
Update this line: `WebDriverManager.chromedriver().version("90.0.4430.24").setup();`
See this link https://chromedriver.chromium.org/downloads to find out what chrome driver version matches your chrome 
browser version

4) run the tests by executing "mvn clean test" in the terminal in the project's root directory
5) You can see the test results in a very pretty format under this folder: 
`target\cucumber-reports\advanced-reports\cucumber-html-reports\`
Look at the html report files.
