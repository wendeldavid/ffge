const firebase = require("firebase");
const functions = require('firebase-functions');
const admin = require('firebase-admin');
// const directTransport = require('nodemailer-direct-transport');
const nodemailer = require('nodemailer');
const cors = require('cors')({origin : true});

const nodeoutlook = require('nodejs-nodemailer-outlook');

admin.initializeApp();
/**
* Here we're using Gmail to send 
*/
let transporter = nodemailer.createTransport({
    service: 'gmail',
    auth: {
        user: 'wendel.przygoda@gmail.com',
        pass: 'Leviathan1!666'
    }
});

exports.sendOutlook = functions.https.onRequest((req, res) => {
    nodeoutlook.sendEmail({
        auth: {
            user: "wendel.hades@hotmail.com",
            pass: "Przygoda1!"
        },
        from: 'sender@outlook.com',
        to: 'wendel.hades@gmail.com',
        subject: 'Hey you, awesome!',
        html: '<b>This is bold text</b>',
        text: 'This is text version!',
        replyTo: 'wendel.przygoda@gmail.com',
        secure: true,
        onError: (e) => console.log(e),
        onSuccess: (i) => console.log(i)
    });
})

exports.sendMail = functions.https.onRequest((req, res) => {
    cors(req, res, () => {
      
        // getting dest email by query string
        // const dest = req.query.dest;
        const dest = 'wendel.hades@gmail.com';

        const mailOptions = {
            from: 'portal-ffge-admin <noreply@ffge-portal.firebaseapp.com>', // Something like: Jane Doe <janedoe@gmail.com>
            to: dest,
            subject: 'I\'M A PICKLE!!!', // email subject
            html: `<p style="font-size: 16px;">Pickle Riiiiiiiiiiiiiiiick!!</p>
                <br />
                <img src="https://images.prod.meredith.com/product/fc8754735c8a9b4aebb786278e7265a5/1538025388228/l/rick-and-morty-pickle-rick-sticker" />
            ` // email content in HTML
        };
  
        // returning result
        return transporter.sendMail(mailOptions, (erro, info) => {
            if(erro){
                return res.send(erro.toString());
            }
            return res.send('Sent');
        });
    });    
});

// exports.sendEmail = functions.https.onRequest((request, response) => {
    
//     const config = {
//         apiKey: 'AIzaSyBofpG_MS_xyQxC4aem8u0Bi8UPCkZdYoA',
//         authDomain: 'ffge-portal.firebaseapp.com',
//         databaseURL: 'https://ffge-portal.firebaseio.com',
//         projectId: 'ffge-portal',
//         storageBucket: 'ffge-portal.appspot.com',
//         messagingSenderId: '895779158267'
//     }

//     var mainApp = firebase.initializeApp(config);
        
//     var transporter = nodemailer.createTransport({
//         service: 'gmail',
//         auth: {
//             user: 'example.gmail.com',
//             pass: 'password'
//         }
//     });
    
//     var nodeToWatch = mainApp.database().ref('ffge-portal/grosserias'); //firebase node to watch
    
//     nodeToWatch.on('child_added', (childSnapshot) => { //fires once for every node in this location
//         console.log('grosseria cadastrada');

//         if (!childSnapshot.val().email_sent) { //check if email has already been sent
    
//             nodeToWatch.child(childSnapshot.key)
//                 .child('email_sent')
//                 .set(firebase.database.ServerValue.TIMESTAMP)
//                 .then((response) => { //set email value to sent
                    
//                 var data = JSON.stringify(childSnapshot.val(), null, 9); //stringify the response so we can attach it in the email
                
//                 // create template based sender function
//                 var sendInfo = transporter.templateSender({
//                     subject: 'Node in firebase updated',
//                     html: 'Hello, data for new node is: {{data}}'
//                 }, {
//                 from: 'example.gmail.com'
//                 });
                
//                 // use template based sender to send a message
//                 sendInfo({
//                     to: 'wendel.hades@gmail.com'
//                 }, {
//                     data: data //data variable to insert into email
//                 }, (err, info) => {
//                     if(err){
//                         console.log(err);
//                     }
//                     else{
//                         console.log('Email sent');
//                     }
//                 });

//                 return 'ok';

//             }).catch((reason) => {
//                 console.log('deu ruim');
//             });
            
//         }
//         return 'fuuu 1';
    
//     });
// });