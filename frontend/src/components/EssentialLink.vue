<template>
  <q-item
    clickable
    tag="a"
    :href="link"
    style="color: #1f2937;"
  >
    <q-item-section v-if="icon" avatar>
      <q-icon :name="icon" :size="iconSize"/>
    </q-item-section>

    <q-item-section>
      <q-item-label class="text-weight-medium text-body1">{{ title }}</q-item-label>
      <q-item-label caption>{{ caption }}</q-item-label>
    </q-item-section>
  </q-item>
</template>

<script setup lang="ts">
export interface EssentialLinkProps {
  title: string;
  caption?: string;
  link?: string;
  icon?: string;
  iconSize?: string;
}
withDefaults(defineProps<EssentialLinkProps>(), {
  caption: '',
  link: '#',
  icon: '',
});
</script>
