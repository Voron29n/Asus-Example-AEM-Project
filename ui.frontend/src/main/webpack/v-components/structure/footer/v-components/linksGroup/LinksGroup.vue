<template>
  <div class="footer-links_group">
    <div
      class="aai-footer-span"
      v-for="linksGroupItem in linksGroupData.linksGroup"
      :key="linksGroupItem.groupTitle"
      @click="openLinkGroup(linksGroupItem.linksNames.length, false, $event)"
    >
      <h4>{{ linksGroupItem.groupTitle }}</h4>
      <ul class="aai-fnav">
        <li v-for="linkItem in linksGroupItem.linksNames" :key="linkItem.descriptionLink">
          <a :href="linkItem.linkTo" :target="linkItem.linkUrlTarget">{{ linkItem.descriptionLink }}</a>
        </li>
      </ul>
    </div>
    <v-socials :socials-data="socialsData" @open-social-group="openLinkGroup"></v-socials>
  </div>
</template>

<script>
import Footer_SocialsCmp from "../socials/Socials";
import { adapt } from "@mixin/adaptFromDesktopToMobileVersion";

export default {
  mixins: [adapt],
  components: {
    // "v-socials": () => import('../socials/Socials'),
    "v-socials": Footer_SocialsCmp,
  },
  props: {
    linksGroupData: Object,
    socialsData: Object,
  },
  data() {
    return {
      isDesktopVersion: false,
    };
  },
  methods: {
    openLinkGroup(countItems, isSocialGroup, event) {
      if (this.isDesktopVersionMeth(720) || event.target.parentElement.isEqualNode(this.$el)) {
        return;
      }

      let parentElement = event.target.parentElement;
      this.closeAllLinksGroup(parentElement);

      if (
        parentElement.style.height === null ||
        parentElement.style.height === ""
      ) {
        let height = isSocialGroup ? 110 : countItems * 44 + 40;
        parentElement.style.height = height + "px";
      } else {
        parentElement.style.height = null;
      }
    },
    closeAllLinksGroup(parentElement) {
      Array.from(this.$el.children).forEach((element) => {
        if (!element.isEqualNode(parentElement)) element.style.height = null;
      });
    },
  },
};
</script>

<style lang="scss">
@import "./links_group_default";
@import "./links_group_media";
</style>
