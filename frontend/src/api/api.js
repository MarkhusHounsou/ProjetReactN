import axios from 'axios';
import { Platform } from 'react-native';

const getBaseUrl = () => {
  if (Platform.OS === 'web') return 'http://localhost:8080/api';
  if (Platform.OS === 'android') return 'http://10.0.2.2:8080/api';
  return 'http://192.168.1.148:8080/api'; // IP pour iOS ou Expo Go physique
}

const api = axios.create({
  baseURL: getBaseUrl(), 
  headers: {
    'Content-Type': 'application/json',
  },
});

export default api;
