<template>
  <q-layout view="hHh Lpr lFf">
    <q-header elevated>
      <q-toolbar>
        <q-btn
          flat
          dense
          round
          icon="menu"
          aria-label="Menu"
          @click="toggleLeftDrawer"
        />
        <q-toolbar-title>
          Quasar App
        </q-toolbar-title>
      </q-toolbar>
    </q-header>

    <q-drawer
      v-model="leftDrawerOpen"
      :mini="drawerState"
      @mouseenter="drawerState = false"
      @mouseleave="drawerState = true"
      show-if-above
      bordered
    >
      <q-list v-if="leftDrawerOpen">
        <q-item-label header>
          Navigations
        </q-item-label>

        <EssentialLink
          v-for="link in essentialLinks"
          :key="link.title"
          v-bind="link"
          :mini="false"
        />
      </q-list>
    </q-drawer>

    <q-page-container>
      <router-view />
    </q-page-container>
  </q-layout>
</template>

<script setup lang="ts">
import { ref } from 'vue';
import EssentialLink, { EssentialLinkProps } from 'components/EssentialLink.vue';

const essentialLinks: EssentialLinkProps[] = [
  {
    title: 'Dashboard',
    icon: 'bi-house-fill',
    iconSize: '29px'
  },
  {
    title: 'Leave Requests',
    caption: 'view remaining or apply request',
    icon: 'bi-folder-fill',
    iconSize: '26px'
  },
  {
    title: 'Employees',
    caption: 'employees table',
    icon: 'bi-people-fill',
    iconSize: '28px'
  },
  {
    title: 'Forum',
    caption: 'discus with teams',
    icon: 'bi-chat-left-dots-fill',
    iconSize: '24px'
  }
];

const leftDrawerOpen = ref(false);
const drawerState = ref(true);

function toggleLeftDrawer() {
  leftDrawerOpen.value = !leftDrawerOpen.value;
}
</script>
