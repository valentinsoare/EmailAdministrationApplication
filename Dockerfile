# this shows how we can extend/change an existing official image from Docker Hub

FROM vsoare/javabubble:17.0.9
# highly recommend you always pin versions for anything beyond dev/learn

WORKDIR /opt
# change working directory to root of nginx webhost
# using WORKDIR is preferred to using 'RUN cd /some/path'

EXPOSE 8080

# I don't have to specify EXPOSE or CMD because they're in my FROM
