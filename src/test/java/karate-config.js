function fn() {
  var env = karate.env; // get system property 'karate.env'
  karate.log('karate.env system property was:', env);
  var config = {
    baseUrl : 'https://petstore.swagger.io/v2',
  }
  karate.configure('headers', { 'Content-Type': 'application/json', 'Accept': 'application/json' });
  return config;
}