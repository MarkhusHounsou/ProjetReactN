import React, { useCallback, useState } from 'react';
import { View, FlatList, StyleSheet, ActivityIndicator, Text } from 'react-native';
import { useFocusEffect } from '@react-navigation/native';
import api from '../api/api';
import SaeCard from '../components/SaeCard';
import COLORS from '../theme/colors';

export default function HomeScreen({ navigation }) {
  const [saes, setSaes] = useState([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);

  useFocusEffect(
    useCallback(() => {
      fetchSaes();
    }, [])
  );

  const fetchSaes = async () => {
    try {
      setLoading(true);
      setError(null);
      const res = await api.get('/saes');
      setSaes(res.data);
    } catch (e) {
      setError("Impossible de contacter le serveur.\nVérifiez que le backend Spring Boot est lancé.");
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

  if (error) {
    return (
      <View style={styles.center}>
        <Text style={styles.errorText}>{error}</Text>
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
        ListEmptyComponent={<Text style={styles.emptyText}>Aucune SAÉ trouvée</Text>}
      />
    </View>
  );
}

const styles = StyleSheet.create({
  container: { flex: 1, backgroundColor: COLORS.background },
  center: { flex: 1, justifyContent: 'center', alignItems: 'center', padding: 24 },
  errorText: { color: 'red', textAlign: 'center', fontSize: 15, lineHeight: 22 },
  emptyText: { textAlign: 'center', marginTop: 20, color: COLORS.textMuted },
});
