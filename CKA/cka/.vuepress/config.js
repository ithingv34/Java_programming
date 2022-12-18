const { getFilesOf } = require('./util.js');

module.exports = {
  base: '/cka/',
  assetsPublicPath: '/',
  title: " Certified Kubernetes Administrator (CKA)",
  plugins: ['@vuepress/last-updated'],
  themeConfig: {
    nav: [
      { text: 'Home', link: '/' }
    ],
    sidebar: [
      ['/', 'Certified Kubernetes Administrator (CKA)'],
      {
        title: 'CKA',
        path: '/docs/CKA/',
        children: getFilesOf('docs/CKA'),
      },
      {
        title: 'Kubernetes',
        path: '/docs/Kubernetes/',
        children: getFilesOf('docs/Kubernetes'),
      },
      {
        title: 'ClusterArchitecture',
        path: '/docs/ClusterArchitecture/',
        children: getFilesOf('docs/ClusterArchitecture'),
      },
      {
        title: 'Workloads Scheduling',
        path: '/docs/Workloads Scheduling/',
        children: getFilesOf('docs/Workloads Scheduling'),
      },
      {
        title: 'Services Networking',
        path: '/docs/Services Networking/',
        children: getFilesOf('docs/Services Networking'),
      },
      {
        title: 'Storage',
        path: '/docs/Storage/',
        children: getFilesOf('docs/Storage'),
      },
      {
        title: 'TroubleShooting',
        path: '/docs/TroubleShooting/',
        children: getFilesOf('docs/TroubleShooting'),
      }
    ],
    repo: 'ithingv34/vuepress_template',
    repoLabel: 'GitHub',
    editLinks: true,
    docsBranch: 'master',
    editLinkText: 'Edit this page🙌!',
  },
};
