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

![install1](https://github.com/user-attachments/assets/9ff75c0d-aa29-445f-9ff4-8fe279f9da87)

![install2](https://github.com/user-attachments/assets/62318344-e497-41af-800e-8d8612986224)

![install3](https://github.com/user-attachments/assets/0a80dfbc-8d7a-423e-af45-476dd7e826ae)

![install4](https://github.com/user-attachments/assets/13c9c3c2-e169-43c6-885e-a2f96637dd17)

![install5](https://github.com/user-attachments/assets/29abde1a-acf3-48f2-b990-933debdeb27c)



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

![plugin0](https://github.com/user-attachments/assets/e768af86-6797-44d9-afcc-ce3fd652a8d4)

[Tools] -> [Plugin]

![plugin1](https://user-images.githubusercontent.com/45158796/170095413-5bbeee99-ce09-442f-abec-4685b929263f.png)

[Download] -> [Add Plugins...]

![plugin2](https://user-images.githubusercontent.com/45158796/170095410-1375959f-9987-49ef-9b12-db325d8a65fb.png)

Select your donwloaded plugin nbm files

![plugin3](https://user-images.githubusercontent.com/45158796/170095409-cbd736d5-8379-4a84-a965-288df2a12a9d.png)

Select all -> [Install]

![plugin4](https://user-images.githubusercontent.com/45158796/170095406-a939d98a-f529-402c-b04d-bc22d4acc711.png)

[Next]

![plugin5](https://user-images.githubusercontent.com/45158796/170095403-478f9f3f-fc38-4855-bb97-f89cd276c0aa.png)

Select 'I accept the terms in all of the license agreements' -> [Install]

![plugin6](https://user-images.githubusercontent.com/45158796/170095397-0a373668-d0c8-4ea2-99e3-36670a1dc87d.png)

![plugin7](https://user-images.githubusercontent.com/45158796/170095391-7f1ccf32-9be6-4c2f-93a5-a4e6e05eab4d.png)

[Finish]


### Configure the python platform
  Configure the python environment in NaDesigner.

![platform0](https://github.com/user-attachments/assets/d6acdab4-5852-4285-bd11-d868896b8b13)

[Tools] -> [Python Platforms]

![platform1](https://user-images.githubusercontent.com/45158796/170095445-1db8170a-c307-4342-8396-b7ae33ce7a0f.png)

[New] in Python Platform Manager Wizard

![platform2](https://user-images.githubusercontent.com/45158796/170095442-d8da6269-5c78-417a-a5c7-904f7c552d9e.png)

Brows your python.exe

![platform3](https://user-images.githubusercontent.com/45158796/170095441-7cdecec7-6ad8-4f41-b72d-5f43ce8898c7.png)

![platform4](https://user-images.githubusercontent.com/45158796/170095448-81c5727f-3937-47cb-960f-4a9be5022375.png)

Confirm your python path


### Requirement
  Download requirement.txt and Install the python dependencies 
  ```
  pip install -r requirement.txt
  ```


## Example

#### Multi-Class Classification (MNIST)

![nadesigner-ai1](https://user-images.githubusercontent.com/45158796/170121560-1e660212-347d-44e9-9952-4a9675021250.png)

![Image](https://github.com/user-attachments/assets/6b22f348-0adf-441f-9031-fa1cbda806ac)

![nadesigner-ai3](https://user-images.githubusercontent.com/45158796/170121531-76ddf581-b03c-45eb-b0f7-5c211441ad2f.png)

![nadesigner-ai4](https://user-images.githubusercontent.com/45158796/170121535-4c6a97df-b4a3-4dd1-af3f-2da1e544f23a.png)

![nadesigner-ai5](https://github.com/user-attachments/assets/d84e0260-cb96-4d4b-bd01-5856806ccbcf)

![nadesigner-ai6](https://user-images.githubusercontent.com/45158796/170121544-2699da23-6aab-4d76-81a2-d30bbaa561fd.png)

![nadesigner-ai7](https://user-images.githubusercontent.com/45158796/170121546-908a7fef-c4c1-445c-b62b-b89cb0ce9a71.png)




#### Try the Model for User-Specific Requirements 

![nadesigner-user1](https://github.com/user-attachments/assets/b1c794a2-f57f-41d3-b99b-57aec63535ec)

![nadesigner-user2](https://github.com/user-attachments/assets/e89e1846-8a3b-4855-a80c-05eeffbdc837)

![nadesigner-user3](https://github.com/user-attachments/assets/e2bfc525-0b4c-41fa-8e19-05b97cc77505)

![nadesigner-user4](https://github.com/user-attachments/assets/1b504870-77ad-4cc2-94da-16818660b193)



### IoT Component 

  The following execercize explains how to use NaDesigner to create the IoT Component.
  
![nadesigner-iot1](https://user-images.githubusercontent.com/45158796/170095474-88f942dd-4f25-4ee4-8bff-d098c590ddac.png)

![Image](https://github.com/user-attachments/assets/f054a2ba-ae4e-42d5-9881-672f0bfd8216)

![nadesigner-iot3](https://user-images.githubusercontent.com/45158796/170095472-8eeebf0b-bd52-4f7b-8e6f-58eb3c121c53.png)

![nadesigner-iot4](https://user-images.githubusercontent.com/45158796/170095468-3f78473c-c41c-4a14-be70-6f5dc3c083a7.png)

![nadesigner-iot5](https://user-images.githubusercontent.com/45158796/170095467-7bdad6fe-4ad6-48a2-919a-3d151ce7e466.png)

![nadesigner-iot6](https://user-images.githubusercontent.com/45158796/170095466-ed4a5203-3270-43d3-8143-6fa2ca6361ed.png)

![nadesigner-iot7](https://user-images.githubusercontent.com/45158796/170095463-58b4055d-48a8-4d8f-b7fb-ee58d100f7a6.png)


## Authors

  Contributors names and contact info
  
  - Seoyeon Kim
  - Jaehyeok Jeong
  - Jaehee Kim
  - Jinman Jung
  - Bongjae Kim
  - Jinsung Cho
