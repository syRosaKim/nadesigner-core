# NA-Designer-Core
Neuromorphic Architecture based Component Designer (Core Sourcecode)

## JDK

Java 1.8

## Installaion

### Download 
 
 Download the following files [here](https://github.com/syRosaKim/nadesigner-core/blob/main/doc/Installation.md)

 1. "NaDesigner-windows" installer  
 2. python plugin
 3. User-driven performance model

 
### Run the Installer
 Run the downloaded installer.

![install1](https://user-images.githubusercontent.com/45158796/170095361-ea3df8e7-300b-4017-8bbe-62e7900b871a.png)

![install2](https://user-images.githubusercontent.com/45158796/170095360-2922e3dd-ad21-4948-b379-84e78578be49.png)

![install4](https://user-images.githubusercontent.com/45158796/170095368-f4155685-d29a-48c6-9667-f63f50ca09cd.png)

![install5](https://user-images.githubusercontent.com/45158796/170095364-6a4b9d08-bad6-4159-83d9-83d734fda725.png)

![install6](https://user-images.githubusercontent.com/45158796/170095363-af2e5186-1761-4af9-b1e3-03541980711b.png)


## Configuration

### Edit the nadesigner.conf
 After installation is complete, edit the `C:\Program Files\nadesigner\etc\nadesigner.conf` file as follows.
 
 ```sh
 # options used by the launcher by default, can be overridden by explicit
 # command line switches
 default_options="--branding nadesigner -J-Xms1024m -J-Xmx2048m"
 # default location of JDK/JRE, can be overridden by using --jdkhome <dir> switch
 jdkhome="your/path/to/jdk"
 ```

### Move the User-driven performance model

```sh
C:\users\YOURUSERNAME\Documents\NaDesigner\Libraries
```

![image](https://github.com/user-attachments/assets/b38e13c0-b5d4-4c17-915f-79d25c3c234b)


### Install the plugin
  Download "Python plugin for nadesigner" installer. 
  Run nadesigner and install the plugin as follows. 

![plugin0](https://github.com/user-attachments/assets/501da0af-44c3-47cf-9d7b-26a7c94997db)

![plugin1](https://user-images.githubusercontent.com/45158796/170095413-5bbeee99-ce09-442f-abec-4685b929263f.png)

![plugin2](https://user-images.githubusercontent.com/45158796/170095410-1375959f-9987-49ef-9b12-db325d8a65fb.png)

![plugin3](https://user-images.githubusercontent.com/45158796/170095409-cbd736d5-8379-4a84-a965-288df2a12a9d.png)

![plugin4](https://user-images.githubusercontent.com/45158796/170095406-a939d98a-f529-402c-b04d-bc22d4acc711.png)

![plugin5](https://user-images.githubusercontent.com/45158796/170095403-478f9f3f-fc38-4855-bb97-f89cd276c0aa.png)

![plugin6](https://user-images.githubusercontent.com/45158796/170095397-0a373668-d0c8-4ea2-99e3-36670a1dc87d.png)

![plugin7](https://user-images.githubusercontent.com/45158796/170095391-7f1ccf32-9be6-4c2f-93a5-a4e6e05eab4d.png)


### Configure the python platform
  Configure the python environment in NaDesigner.

[Tools] -> [Python Platforms]

![platform1](https://user-images.githubusercontent.com/45158796/170095445-1db8170a-c307-4342-8396-b7ae33ce7a0f.png)

[New] in Python Platform Manager Wizard

![platform2](https://user-images.githubusercontent.com/45158796/170095442-d8da6269-5c78-417a-a5c7-904f7c552d9e.png)

![platform3](https://user-images.githubusercontent.com/45158796/170095441-7cdecec7-6ad8-4f41-b72d-5f43ce8898c7.png)

![platform4](https://user-images.githubusercontent.com/45158796/170095448-81c5727f-3937-47cb-960f-4a9be5022375.png)


### Requirement
  Download requirement.txt and Install the python dependencies 
  ```
  pip install -r requirement.txt
  ```


## Example





## Authors

  Contributors names and contact info
  
  - Seoyeon Kim
  - Jaehyeok Jeong
  - Jaehee Kim
  - Jinman Jung
  - Bongjae Kim
  - Jinsung Cho
