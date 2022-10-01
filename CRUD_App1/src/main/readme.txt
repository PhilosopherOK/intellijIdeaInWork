Tomcat по default на старте обращается к странице index
которая неявно у вас указана в web.xml, что бы изменить
стартовую страницу нужно.

Задекларировать в web.xml

<welcome-file-list>
    <welcome-file></welcome-file>
</welcome-file-list>
И добавить mapping

@GetMapping(value = {"/hello-world", "/"})




Заходите в настройки вашего томката -> Deployment ->
внизу в Application context ставите "/".
 И уже потом перезагружаете сервер и переходите по маппингам