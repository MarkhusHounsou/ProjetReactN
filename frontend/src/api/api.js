import axios from 'axios';
import { Platform } from 'react-native';

// Pour Expo Go sur appareil physique iOS ou Android réel,
// remplacez EXPO_GO_HOST par l'IP de votre machine sur le réseau local.
const EXPO_GO_HOST = '192.168.1.148';

const getBaseUrl = () => {
  if (Platform.OS === 'web') return 'http://localhost:8080/api';
  if (Platform.OS === 'android') return 'http://10.0.2.2:8080/api';
  return `http://${EXPO_GO_HOST}:8080/api`;
};

const api = axios.create({
  baseURL: getBaseUrl(),
  timeout: 10000,
  headers: {
    'Content-Type': 'application/json',
  },
});

api.interceptors.response.use(
  (response) => response,
  (error) => {
    if (error.response) {
      console.error(`[API] Erreur ${error.response.status}:`, error.response.data);
    } else if (error.request) {
      console.error('[API] Pas de réponse du serveur:', error.message);
    } else {
      console.error('[API] Erreur de configuration:', error.message);
    }
    return Promise.reject(error);
  }
);

export default api;
