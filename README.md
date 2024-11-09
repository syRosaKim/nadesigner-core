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

#### Try the Model for User-Specific Requirements 


#### Multi-Class Classification (MNIST)

![nadesigner-ai1](https://user-images.githubusercontent.com/45158796/170121560-1e660212-347d-44e9-9952-4a9675021250.png)

![nadesigner-ai2](https://user-images.githubusercontent.com/45158796/170121524-5152594f-9bbd-4876-a8c0-34ee94d53507.png)

![nadesigner-ai3](https://user-images.githubusercontent.com/45158796/170121531-76ddf581-b03c-45eb-b0f7-5c211441ad2f.png)

![nadesigner-ai4](https://user-images.githubusercontent.com/45158796/170121535-4c6a97df-b4a3-4dd1-af3f-2da1e544f23a.png)

![nadesigner-ai5](https://github.com/user-attachments/assets/2e2f4b5c-d0ff-45c5-ba16-102c489cf028)

![nadesigner-ai6](https://user-images.githubusercontent.com/45158796/170121544-2699da23-6aab-4d76-81a2-d30bbaa561fd.png)

![nadesigner-ai7](https://user-images.githubusercontent.com/45158796/170121546-908a7fef-c4c1-445c-b62b-b89cb0ce9a71.png)



### IoT Component 

  The following execercize explains how to use NaDesigner to create the IoT Component.
  
![nadesigner-iot1](https://user-images.githubusercontent.com/45158796/170095474-88f942dd-4f25-4ee4-8bff-d098c590ddac.png)

![nadesigner-iot2](https://user-images.githubusercontent.com/45158796/170095473-374623ff-d220-444b-bcb5-69c9cd781fa7.png)

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
