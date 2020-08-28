<template>
  <div>
    <div class="span3">
      <div class="visible-phone" id="phone-list-menu">
        <div class="btn-group">
          <div class="nav-btn dropdown-toggle-nav" @click="openLinkGroup()">
            Все примеры реализации
            <span class="caret"></span>
          </div>
          <div
            id="dropdown-menu-flex"
            :class="{ 'dropdown-menu-flex-visible': isActive }"
          >
            <ul
              class="dropdown-menu"
              v-for="linksGroupItem in linksGroupData.linksGroup"
              :key="linksGroupItem.groupTitle"
            >
              <li
                v-for="linkItem in linksGroupItem.linksNames"
                :key="linkItem.descriptionLink"
              >
                <a :href="linkItem.linkTo">{{ linkItem.descriptionLink }}</a>
              </li>
            </ul>
          </div>
        </div>
      </div>

      <nav class="hidden-phone">
        <ul class="member-func unstyled"
              v-for="linksGroupItem in linksGroupData.linksGroup"
              :key="linksGroupItem.groupTitle"
        >
            <span>{{linksGroupItem.groupTitle}}</span>
            <li
              v-for="linkItem in linksGroupItem.linksNames"
              :key="linkItem.descriptionLink"
            >
              <a :href="linkItem.linkTo">{{ linkItem.descriptionLink }}</a>
            </li>
        </ul>
      </nav>

    </div>
  </div>
</template>

<script>
import { adapt } from "@mixin/adaptFromDesktopToMobileVersion";

export default {
  mixins: [adapt],
  props: {
    linksGroupData: Object,
  },
  data() {
    return {
      isDesktopVersion: false,
      isActive: false,
    };
  },
  methods: {
    openLinkGroup() {
      if (this.isDesktopVersionMeth(720)) {
        return;
      }
      this.isActive = !this.isActive;
    },
  },
};
</script>

<style lang="scss">
@import "./links_group_default";
@import "./links_group_media";
</style>
