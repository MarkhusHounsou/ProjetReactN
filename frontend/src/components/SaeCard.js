import React from 'react';
import { View, Text, StyleSheet, Image, TouchableOpacity } from 'react-native';
import COLORS from '../theme/colors';

export default function SaeCard({ sae, onPress }) {
  return (
    <TouchableOpacity style={styles.card} onPress={onPress}>
      <Image 
        source={{ uri: sae.imageUrl || 'https://via.placeholder.com/300' }} 
        style={styles.image} 
      />
      <View style={styles.content}>
        <View style={styles.header}>
          <Text style={styles.title}>{sae.titre}</Text>
          <Text style={styles.note}>{sae.note ? `${sae.note}/20` : 'Pas de note'}</Text>
        </View>
        <Text style={styles.domaine}>{sae.domaine} • {sae.semestre}</Text>
        <Text style={styles.description} numberOfLines={2}>{sae.description}</Text>
      </View>
    </TouchableOpacity>
  );
}

const styles = StyleSheet.create({
  card: {
    backgroundColor: COLORS.card,
    borderRadius: 16,
    marginBottom: 16,
    marginHorizontal: 16,
    shadowColor: '#000',
    shadowOpacity: 0.1,
    shadowOffset: { width: 0, height: 4 },
    shadowRadius: 8,
    elevation: 3,
    overflow: 'hidden'
  },
  image: { height: 160, width: '100%' },
  content: { padding: 16 },
  header: { flexDirection: 'row', justifyContent: 'space-between', alignItems: 'center' },
  title: { fontSize: 18, fontWeight: '700', color: COLORS.textBase, flex: 1 },
  note: { fontSize: 16, fontWeight: 'bold', color: COLORS.primary, backgroundColor: '#E0E7FF', paddingHorizontal: 8, paddingVertical: 4, borderRadius: 8 },
  domaine: { fontSize: 13, color: COLORS.textMuted, marginTop: 4, fontWeight: '500' },
  description: { fontSize: 14, color: COLORS.textMuted, marginTop: 8, lineHeight: 20 }
});
