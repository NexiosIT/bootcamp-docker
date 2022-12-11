FROM nginx
# Nginx serves files in this directory
WORKDIR /usr/share/nginx/html
# Remove example files
RUN rm -rf ./*
COPY index.html .
ENTRYPOINT ["nginx", "-g", "daemon off;"]