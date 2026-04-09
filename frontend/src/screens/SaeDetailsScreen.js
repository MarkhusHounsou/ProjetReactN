import React from 'react';
import { View, Text, StyleSheet, FlatList } from 'react-native';
import COLORS from '../theme/colors';

export default function SaeDetailsScreen({ route }) {
  const sae = route.params?.sae;

  if (!sae) {
    return (
      <View style={styles.center}>
        <Text style={styles.errorText}>SAÉ introuvable.</Text>
      </View>
    );
  }

  const renderStudentGrade = ({ item }) => {
    return (
      <View style={styles.gradeCard}>
        <Text style={styles.studentName}>{item.nom}</Text>
        <Text style={[styles.studentGrade, item.valeur == null && styles.noGrade]}>
          {item.valeur != null ? item.valeur : "Pas de note"}
        </Text>
      </View>
    );
  };

  return (
    <View style={styles.container}>
      <View style={styles.header}>
        <Text style={styles.title}>{sae.titre}</Text>
        <Text style={styles.subtitle}>{sae.semestre} | {sae.description}</Text>
      </View>

      <Text style={styles.sectionTitle}>Notes des Étudiants</Text>
      <FlatList
        data={sae.notesEtudiants ?? []}
        keyExtractor={(item) => item.id.toString()}
        renderItem={renderStudentGrade}
        contentContainerStyle={styles.listContainer}
        ListEmptyComponent={<Text style={styles.emptyText}>Aucune note disponible.</Text>}
      />
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: COLORS.background,
  },
  center: {
    flex: 1,
    justifyContent: 'center',
    alignItems: 'center',
  },
  errorText: {
    color: 'red',
    fontSize: 16,
  },
  header: {
    padding: 20,
    backgroundColor: COLORS.card,
    borderBottomWidth: 1,
    borderBottomColor: COLORS.border,
    marginBottom: 10,
  },
  title: {
    fontSize: 24,
    fontWeight: 'bold',
    color: COLORS.textBase,
  },
  subtitle: {
    fontSize: 14,
    color: COLORS.textMuted,
    marginTop: 5,
  },
  sectionTitle: {
    fontSize: 18,
    fontWeight: 'bold',
    marginLeft: 20,
    marginBottom: 10,
    marginTop: 10,
    color: COLORS.textBase,
  },
  listContainer: {
    paddingHorizontal: 20,
    paddingBottom: 20,
  },
  gradeCard: {
    flexDirection: 'row',
    justifyContent: 'space-between',
    padding: 15,
    backgroundColor: COLORS.card,
    borderRadius: 8,
    marginBottom: 10,
    shadowColor: '#000',
    shadowOffset: { width: 0, height: 1 },
    shadowOpacity: 0.1,
    shadowRadius: 2,
    elevation: 2,
  },
  studentName: {
    fontSize: 16,
    color: COLORS.textBase,
    fontWeight: '500',
  },
  studentGrade: {
    fontSize: 16,
    fontWeight: 'bold',
    color: COLORS.primary,
  },
  noGrade: {
    color: COLORS.textMuted,
    fontStyle: 'italic',
  },
  emptyText: {
    textAlign: 'center',
    color: COLORS.textMuted,
    marginTop: 20,
    fontStyle: 'italic',
  },
});
