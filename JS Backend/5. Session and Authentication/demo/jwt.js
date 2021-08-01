const jwt = require('jsonwebtoken');

const payload = { message: 'hi' };
const secret = "my-secret-key";

const token = jwt.sign(payload, secret, { expiresIn: '2d' });

const mytoken = 'eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJtZXNzYWdlIjoiaGkiLCJpYXQiOjE2Mjc4MzMxNjIsImV4cCI6MTYyODAwNTk2Mn0.aRmXRRtIsn2Ok-CnkE8vmA_7rEpGO7GnvxEEJpWH7ho';

console.log(jwt.verify(mytoken, secret));