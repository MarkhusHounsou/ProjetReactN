import React, { useEffect, useState } from 'react';
import { View, FlatList, StyleSheet, ActivityIndicator, Text } from 'react-native';
import api from '../api/api';
import SaeCard from '../components/SaeCard';
import COLORS from '../theme/colors';

export default function HomeScreen({ navigation }) {
  const [saes, setSaes] = useState([]);
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    const unsubscribe = navigation.addListener('focus', () => {
      fetchSaes();
    });
    return unsubscribe;
  }, [navigation]);

  const fetchSaes = async () => {
    try {
      setLoading(true);
      const res = await api.get('/saes');
      setSaes(res.data);
    } catch (e) {
      console.warn("Erreur API : Avez-vous lancé le Spring Boot ?");
    } finally {
      setLoading(false);
    }
  };

  if (loading) {
    return (
      <View style={styles.center}>
        <ActivityIndicator size="large" color={COLORS.primary} />
      </View>
    );
  }

  return (
    <View style={styles.container}>
      <FlatList
        data={saes}
        keyExtractor={(item) => item.id.toString()}
        renderItem={({ item }) => (
          <SaeCard sae={item} onPress={() => navigation.navigate("SaeDetails", { sae: item })} />
        )}
        contentContainerStyle={{ paddingVertical: 16 }}
        ListEmptyComponent={<Text style={{textAlign:'center', marginTop:20}}>Aucune SAÉ trouvée</Text>}
      />
    </View>
  );
}

const styles = StyleSheet.create({
  container: { flex: 1, backgroundColor: COLORS.background },
  center: { flex: 1, justifyContent: 'center', alignItems: 'center' }
});
