<h3><strong>Inventario de vacunaci&oacute;n - Docker Compose</strong></h3>
<p><span>Esta gu&iacute;a lo gu&iacute;a a trav&eacute;s del proceso de creaci&oacute;n de una imagen de Docker</span><span> para ejecutar la aplicaci&oacute;n de inventario de vacunaci&oacute;n. </span><span>Esta es una gu&iacute;a de "inicio", por lo que el alcance se limita a unas pocas necesidades b&aacute;sicas.</span></p>
<p><strong>Contiene</strong></p>
<ul>
<li>Spring Boot</li>
<li>Maven</li>
<li>Spring Cloud Feign</li>
<li>PostgreSQL</li>
<li>Documentaci&oacute;n API REST con Swagger</li>
</ul>
<p><strong>Requisitos previos GIT en el servidor - Generar la clave p&uacute;blica </strong></p>
<p>Para generar la clave p&uacute;blica se sugiere seguir las instrucciones del siguiente tutorial:<br /><a href="https://git-scm.com/book/es/v2/Git-en-el-Servidor-Generando-tu-clave-p%C3%BAblica-SSH ">https://git-scm.com/book/es/v2/Git-en-el-Servidor-Generando-tu-clave-p%C3%BAblica-SSH </a></p>
<p>Para m&aacute;s detalles de c&oacute;mo crear claves SSH, consultar la gu&iacute;a correspondiente de GitLab<br /><a href="https://docs.gitlab.com/ee/ssh/index.html ">https://docs.gitlab.com/ee/ssh/index.html </a></p>
<p>&nbsp;</p>
<p>A continuaci&oacute;n, las opciones de instalaci&oacute;n de Docker y Docker Compose, dependiendo del sistema operativo.</p>
<p><strong>Sistemas Operativos basados en WINDOWS</strong></p>
<p>Instalar Docker Desktop<br /><a href="https://docs.docker.com/desktop/windows/install/ ">https://docs.docker.com/desktop/windows/install/ </a></p>
<p>Instalar el Subsitema de Windows para Linux (WSL) <a href="https://docs.microsoft.com/es-es/windows/wsl/install ">https://docs.microsoft.com/es-es/windows/wsl/install </a> <br /><a href="https://docs.microsoft.com/es-es/windows/wsl/install-manual">https://docs.microsoft.com/es-es/windows/wsl/install-manual</a></p>
<p><strong>Para cualquier otro sistema operativo, se necesita de lo siguiente: </strong></p>
<ul>
<li>Servidor de Ubuntu 20.04 y un usuario no root con privilegios sudo.</li>
<li>Docker instalado y C&oacute;mo instalar y usar Docker en Ubuntu 20.04.</li>
</ul>
<p style="padding-left: 40px;"><a href="https://www.digitalocean.com/community/tutorials/how-to-install-and-use-docker-on-ubuntu-20-04">https://www.digitalocean.com/community/tutorials/how-to-install-and-use-docker-on-ubuntu-20-04</a></p>
<ul>
<li>Docker Compose instalado y C&oacute;mo instalar Docker Compose en Ubuntu 20.04</li>
</ul>
<p style="padding-left: 40px;"><a href="https://www.digitalocean.com/community/tutorials/how-to-install-and-use-docker-compose-on-ubuntu-20-04 ">https://www.digitalocean.com/community/tutorials/how-to-install-and-use-docker-compose-on-ubuntu-20-04</a></p>
<p><strong>Pasos a seguir</strong></p>
<p>Los pasos a seguir son los siguientes:</p>
<p><strong>Paso 1.- Clonar el proyecto</strong></p>
<p>En el proyecto se encuentran los fuentes y los archivos necesarios para levantar el ambiente.</p>
<pre>git clone <a href="https://gitlab.com/privateupgrades/front.git ">https://github.com/miriamjaramillo/inventario_vacunacion.git</a></pre>
<p><strong>Paso 2.- Abrir las aplicaciones en Spring Tool Suite y generar los archivos .jar</strong></p>
<p>Abrir los proyectos administrador, empleado e inventario en Spring Tool Suite y posteriormente generar los .jar, tal como se muestra en la siguiente imagen:</p>
<p><img src="https://raw.githubusercontent.com/miriamjaramillo/inventario_vacunacion/main/mavenBuild.png" width="476" height="467" /></p>
<p><strong>Paso 3.- Copiar los archivos necesarios en su proyecto </strong></p>
<p>Copiar los archivos .jar que se generaron en el paso anterior en la carpeta jar descargada. Este paso es muy importante, pues en los archivos DockerFile que se mencionaran posteriormente, hacen referencia a esta ruta.</p>
<p><strong>Paso 4.- Verificar el nombre de los proyectos .jar generados</strong></p>
<p>Verificar que el nombre de los proyectos .jar generados coincidan con cada uno de los nombres de los proyectos mencionados en el directorio docker_file.</p>
<p>Notar que por cada proyecto se cre&oacute; un archivo Dockerfile, quedando de la siguiente manera:</p>
<pre>administrador =&gt; docker_file/administrador.dockerfile<br />empleado =&gt; docker_file/empleado.dockerfile<br />inventario=&gt; docker_file/inventario.dockerfile</pre>
<p>En la siguiente imagen se visualiza la configuraci&oacute;n de uno de los archivos Dockerfile.</p>
<p><img src="https://raw.githubusercontent.com/miriamjaramillo/inventario_vacunacion/main/nombreProyecto.PNG" alt="" width="846" height="305" /></p>
<p>Si los archivos .jar se generan con un nombre diferente, cambiar en la ubicaci&oacute;n mencionada en la imagen anterior.</p>
<p><strong>Paso 5.- Levantando el ambiente Iniciar los contenedores desde el directorio ra&iacute;z del proyecto </strong></p>
<pre>docker-compose up -d
docker-compose ps</pre>
<p>Con el &uacute;ltimo comando de este paso podr&aacute; listar los contenedores creados.</p>
<p><strong>Paso 6.- Acceso mediante Swagger.</strong></p>
<p>Las URLs de acceso a los distintos microservicios son:</p>
<pre><a href="http://localhost:8001/swagger-ui.html">http://localhost:8001/swagger-ui.html</a><br /><a href="http://localhost:8002/swagger-ui.html">http://localhost:8002/swagger-ui.html</a><br /><a href="http://localhost:8003/swagger-ui.html">http://localhost:8003/swagger-ui.html</a><br /><br /></pre>
<p>Para la validaci&oacute;n de los endpoints se adjunta los archivos json generados con la herramienta Postman.</p>
<p><strong>Agregar/Eliminar/Modificar servicios de docker-compose</strong></p>
<p>Para agregar/eliminar/modificar cualquier servicio m&aacute;s adelante (despu&eacute;s de docker-compose up), recuerde ejecutar los siguientes comandos desde el directorio del proyecto para aplicar sus cambios:</p>
<pre>docker-compose down
docker-compose up --force-recreate --build -d
docker image prune -f
</pre>
