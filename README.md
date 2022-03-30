# visits-count

Visits counting redis demo application

Demo project to learn Redis

Run to deploy:
docker-compose up

Default application port is 8080

API:
/time - last time visited from current IP address
/ip - amount of times visited from current IP address
/agent - amount of times visited from current 'User-Agent'
/ - amount of times sent 'GET' requests
POST / - amount of times sent 'POST' requests
