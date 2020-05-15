<?php

ini_set('SMTP','smtp.free.fr');
ini_set('sendmail_from', 'jeanpierre.tran.fr@gmail.com');

	if(isset($_POST['submit'])){
		$name=$_POST['name'];
		$email=$_POST['email'];
		$phone=$_POST['phone'];
		$msg=$_POST['msg'];

		$to='jeanpierre.tran.fr@gmail.com'; // Receiver Email ID, Replace with your email ID
		$subject='Formulaire';
		$message="Nom :".$name."\n"."Telephone :".$phone."\n"."Le message :"."\n\n".$msg;
		$headers="De: ".$email;

		if(mail($to, $subject, $message, $headers)){
			echo "<h1>Message envoyer! Merci"." ".$name.", nous allons vous contactez plus tard!</h1>";
		}
		else{
			echo "Message pas envoyer!";
		}
	}
?>