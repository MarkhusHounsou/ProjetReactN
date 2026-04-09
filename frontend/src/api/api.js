import axios from 'axios';

// IMPORTANT: Remplace 192.168.1.X par ton IP locale IPv4
const api = axios.create({
  baseURL: 'http://192.168.1.155:8080/api', 
  headers: {
    'Content-Type': 'application/json',
  },
});

export default api;
