package com.noon.base;

import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import com.noon.dao.DaoOrder;

public class Panel05Order04Option extends JPanel {

	private JLabel lblNewLabel_01;
	private JLabel lblBtnTabOrder;
	private JLabel lblBtnTabMypage;
	private JLabel lblHomeIndicator;
	private JLabel lblBtnTabHome;
	private JLabel lblBtnTabGift;
	private JLabel lblBtnSidebar;
	private JLabel lblBtnBack;
	private JLabel lblProfilePhoto;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JButton btnHot;
	private JButton btnIce;
	private JButton btnSizeTall;
	private JButton btnSizeRegular;
	private JButton btnSizeGrande;
	private JButton btnShot0;
	private JButton btnShot1;
	private JButton btnShot2;
	private JButton btnShot3;
	private JButton btnSyrupNot;
	private JButton btnSyrupHazelnut;
	private JLabel lblOptionReset;
	private JLabel lblNewLabel_5;
	private JLabel btnMinus;
	private JLabel btnPlus;
	private JLabel lblOrderQuentity;
	private JLabel lblBtnPutIn;
	private JPanel pnCategoryCoffee;
	private JLabel lblpn1Background;
	private JPanel pnCategoryTeaBeverage;
	private JButton btnHotPn2;
	private JButton btnIcePn2;
	private JButton btnSizeTallPn2;
	private JButton btnSizeRegularPn2;
	private JButton btnSizeGrandePn2;
	private JLabel lblPn2Background;
	private JButton btnSyrupVanila;
	private JLabel lblOptionInfo;

	//
	private String hoticeCheck = "Hot";
	private String sizeCheck = "Tall";
	private String shotCheck = "기본";
	private String syrupCheck = "없음";

	// static
	public static int hotice;
	public static int size;
	public static int shot;
	public static int syrup;
	public static int quantity = 1;

	// 바탕화면 그라데이션
	// -------------------------------------------------------------------------------
	@Override
	protected void paintChildren(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		GradientPaint g3 = new GradientPaint(0, 0, Color.decode("#F4D2C9"), 0, getHeight(), Color.decode("#FAF3E0"));
		g2.setPaint(g3);
		g2.fillRoundRect(0, 0, getWidth(), getHeight(), 0, 0);
		super.paintChildren(g);
	}
	// ----------------------------------------------------------------------------------------------

	/**
	 * Create the panel.
	 */
	public Panel05Order04Option() {
		setBounds(0, 0, 375, 812);
		setOpaque(true);
		setLayout(null);
		add(getLblBtnSidebar());
		add(getLblBtnBack());

		add(getLblNewLabel_01());
		add(getLblProfilePhoto());
		add(getLblBtnTabHome());
		add(getLblBtnTabOrder());
		add(getLblBtnTabGift());
		add(getLblBtnTabMypage());
		add(getLblHomeIndicator());
		add(getLblNewLabel());
		add(getLblNewLabel_1());
		add(getLblOptionReset());
		add(getLblNewLabel_5());
		add(getBtnMinus());
		add(getBtnPlus());
		add(getLblOrderQuentity());
		add(getLblBtnPutIn());
		add(getPnCategoryCoffee());
		add(getPnCategoryTeaBeverage());
		add(getLblOptionInfo());
	}

	// 상단바
	// =============================================================================================================
	private JLabel getLblBtnSidebar() {
		if (lblBtnSidebar == null) {
			lblBtnSidebar = new JLabel("");
			lblBtnSidebar.setHorizontalAlignment(SwingConstants.CENTER);
			lblBtnSidebar
					.setIcon(new ImageIcon("/Users/sangwon_kim/GitHub/Noon/App/src/com/noon/app/icon_sidebar.png"));
			lblBtnSidebar.setBounds(13, 26, 36, 32);
		}
		return lblBtnSidebar;
	}

	private JLabel getLblBtnBack() {
		if (lblBtnBack == null) {
			lblBtnBack = new JLabel("");
			lblBtnBack.setHorizontalAlignment(SwingConstants.CENTER);
			lblBtnBack.setIcon(new ImageIcon("/Users/sangwon_kim/GitHub/Noon/App/src/com/noon/app/icon_back.png"));
			lblBtnBack.setBounds(51, 26, 32, 32);
		}
		return lblBtnBack;
	}

	private JLabel getLblNewLabel_01() {
		if (lblNewLabel_01 == null) {
			lblNewLabel_01 = new JLabel("옵션 선택");
			lblNewLabel_01.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_01.setForeground(new Color(176, 108, 89));
			lblNewLabel_01.setFont(new Font("Lucida Grande", Font.PLAIN, 28));
			lblNewLabel_01.setBounds(131, 26, 115, 37);
		}
		return lblNewLabel_01;
	}

	private JLabel getLblProfilePhoto() {
		if (lblProfilePhoto == null) {
			lblProfilePhoto = new JLabel("");
			lblProfilePhoto.setHorizontalAlignment(SwingConstants.TRAILING);
			lblProfilePhoto
					.setIcon(new ImageIcon("/Users/sangwon_kim/GitHub/Noon/App/src/com/noon/app/profile_photo.png"));
			lblProfilePhoto.setBounds(322, 26, 36, 36);
		}
		return lblProfilePhoto;
	}
	// ==================================================================================================================

	// Tabbar
	// ===========================================================================================================
	private JLabel getLblBtnTabHome() {
		if (lblBtnTabHome == null) {
			lblBtnTabHome = new JLabel("");
			lblBtnTabHome.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					setVisible(false);
					Main.frame.getContentPane().add(new Panel03Home());
				}
			});
			lblBtnTabHome.setIcon(new ImageIcon("/Users/sangwon_kim/GitHub/Noon/App/src/com/noon/app/tabbar_home.png"));
			lblBtnTabHome.setBounds(1, 729, 94, 50);
		}
		return lblBtnTabHome;
	}

	private JLabel getLblBtnTabOrder() {
		if (lblBtnTabOrder == null) {
			lblBtnTabOrder = new JLabel("");
			lblBtnTabOrder.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					setVisible(false);
					Main.frame.getContentPane().add(new Panel05Order01Shop());
				}
			});
			lblBtnTabOrder
					.setIcon(new ImageIcon("/Users/sangwon_kim/GitHub/Noon/App/src/com/noon/app/tabbar_order.png"));
			lblBtnTabOrder.setBounds(95, 729, 94, 50);
		}
		return lblBtnTabOrder;
	}

	private JLabel getLblBtnTabGift() {
		if (lblBtnTabGift == null) {
			lblBtnTabGift = new JLabel("");
			lblBtnTabGift.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					setVisible(false);
					Main.frame.getContentPane().add(new Panel06Gift());
				}
			});
			lblBtnTabGift.setIcon(new ImageIcon("/Users/sangwon_kim/GitHub/Noon/App/src/com/noon/app/tabbar_gift.png"));
			lblBtnTabGift.setBounds(187, 729, 94, 50);
		}
		return lblBtnTabGift;
	}

	private JLabel getLblBtnTabMypage() {
		if (lblBtnTabMypage == null) {
			lblBtnTabMypage = new JLabel("");
			lblBtnTabMypage.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					setVisible(false);
					Main.frame.getContentPane().add(new Panel04MyPage());
				}
			});
			lblBtnTabMypage
					.setIcon(new ImageIcon("/Users/sangwon_kim/GitHub/Noon/App/src/com/noon/app/tabbar_mypage.png"));
			lblBtnTabMypage.setBounds(281, 729, 94, 50);
		}
		return lblBtnTabMypage;
	}

	private JLabel getLblHomeIndicator() {
		if (lblHomeIndicator == null) {
			lblHomeIndicator = new JLabel("");
			lblHomeIndicator
					.setIcon(new ImageIcon("/Users/sangwon_kim/GitHub/Noon/App/src/com/noon/app/homeindicator.png"));
			lblHomeIndicator.setBounds(1, 778, 375, 34);
		}
		return lblHomeIndicator;
	}
	// ==================================================================================================================

	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("");
			lblNewLabel_1.setIcon(new ImageIcon("./" + Panel05Order03Menu.selectedPhoto));
			lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_1.setBounds(138, 100, 100, 100);
		}
		return lblNewLabel_1;
	}

	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel(Panel05Order03Menu.selectedMenu);
			lblNewLabel.setForeground(new Color(176, 108, 89));
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setFont(new Font("SansSerif", Font.PLAIN, 20));
			lblNewLabel.setBounds(1, 200, 374, 32);
		}
		return lblNewLabel;
	}

	// =================================================
	private JPanel getPnCategoryCoffee() {
		if (pnCategoryCoffee == null) {
			pnCategoryCoffee = new JPanel();
			pnCategoryCoffee.setBackground(new Color(255, 0, 0, 0));
			pnCategoryCoffee.setBounds(20, 244, 335, 277);
			pnCategoryCoffee.setLayout(null);
			pnCategoryCoffee.add(getBtnHot());
			pnCategoryCoffee.add(getBtnIce());
			pnCategoryCoffee.add(getBtnSizeTall());
			pnCategoryCoffee.add(getBtnSizeRegular());
			pnCategoryCoffee.add(getBtnSizeGrande());
			pnCategoryCoffee.add(getBtnShot0());
			pnCategoryCoffee.add(getBtnShot1());
			pnCategoryCoffee.add(getBtnShot2());
			pnCategoryCoffee.add(getBtnShot3());
			pnCategoryCoffee.add(getBtnSyrupNot());
			pnCategoryCoffee.add(getBtnSyrupHazelnut());
			pnCategoryCoffee.add(getBtnSyrupVanila());
			pnCategoryCoffee.add(getLblpn1Background());

			//
			if (Panel05Order03Menu.selectedCategory.equals("coffee")) {
			} else {
				pnCategoryCoffee.setVisible(false);
			}
			System.out.println(Panel05Order03Menu.selectedCategory);
		}
		return pnCategoryCoffee;
	}

	private JButton getBtnHot() {
		if (btnHot == null) {
			btnHot = new JButton("");
			btnHot.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					hoticeCheck = "Hot";
					optionInfo();
				}
			});
			btnHot.setIcon(new ImageIcon("/Users/sangwon_kim/GitHub/Noon/App/src/com/noon/app/btn_hot1.png"));
			btnHot.setBounds(87, 20, 77, 32);
		}
		return btnHot;
	}

	private JButton getBtnIce() {
		if (btnIce == null) {
			btnIce = new JButton("");
			btnIce.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					hoticeCheck = "Ice";
					optionInfo();
				}
			});
			btnIce.setIcon(new ImageIcon("/Users/sangwon_kim/GitHub/Noon/App/src/com/noon/app/btn_ice1.png"));
			btnIce.setBounds(232, 20, 77, 32);
		}
		return btnIce;
	}

	private JButton getBtnSizeTall() {
		if (btnSizeTall == null) {
			btnSizeTall = new JButton("");
			btnSizeTall.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					sizeCheck = "Tall";
					optionInfo();
				}
			});
			btnSizeTall.setIcon(new ImageIcon("/Users/sangwon_kim/GitHub/Noon/App/src/com/noon/app/btn_size_tall.png"));
			btnSizeTall.setBounds(87, 86, 45, 31);
		}
		return btnSizeTall;
	}

	private JButton getBtnSizeRegular() {
		if (btnSizeRegular == null) {
			btnSizeRegular = new JButton("");
			btnSizeRegular.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					sizeCheck = "Regular";
					optionInfo();
				}
			});
			btnSizeRegular
					.setIcon(new ImageIcon("/Users/sangwon_kim/GitHub/Noon/App/src/com/noon/app/btn_size_regular.png"));
			btnSizeRegular.setBounds(146, 86, 78, 31);
		}
		return btnSizeRegular;
	}

	private JButton getBtnSizeGrande() {
		if (btnSizeGrande == null) {
			btnSizeGrande = new JButton("");
			btnSizeGrande.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					sizeCheck = "Grande";
					optionInfo();
				}
			});
			btnSizeGrande
					.setIcon(new ImageIcon("/Users/sangwon_kim/GitHub/Noon/App/src/com/noon/app/btn_size_grande.png"));
			btnSizeGrande.setBounds(237, 86, 72, 31);
		}
		return btnSizeGrande;
	}

	private JButton getBtnShot0() {
		if (btnShot0 == null) {
			btnShot0 = new JButton("");
			btnShot0.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					shotCheck = "";
					optionInfo();
				}
			});
			btnShot0.setIcon(new ImageIcon("/Users/sangwon_kim/GitHub/Noon/App/src/com/noon/app/btn_shot_basic.png"));
			btnShot0.setBounds(87, 151, 45, 31);
		}
		return btnShot0;
	}

	private JButton getBtnShot1() {
		if (btnShot1 == null) {
			btnShot1 = new JButton("");
			btnShot1.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					shotCheck = "+1샷";
					optionInfo();
				}
			});
			btnShot1.setIcon(new ImageIcon("/Users/sangwon_kim/GitHub/Noon/App/src/com/noon/app/btn_shot_plus1.png"));
			btnShot1.setBounds(146, 151, 45, 31);
		}
		return btnShot1;
	}

	private JButton getBtnShot2() {
		if (btnShot2 == null) {
			btnShot2 = new JButton("");
			btnShot2.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					shotCheck = "+2샷";
					optionInfo();
				}
			});
			btnShot2.setIcon(new ImageIcon("/Users/sangwon_kim/GitHub/Noon/App/src/com/noon/app/btn_shot_plus2.png"));
			btnShot2.setBounds(205, 151, 45, 31);
		}
		return btnShot2;
	}

	private JButton getBtnShot3() {
		if (btnShot3 == null) {
			btnShot3 = new JButton("");
			btnShot3.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					shotCheck = "+3샷";
					optionInfo();
				}
			});
			btnShot3.setIcon(new ImageIcon("/Users/sangwon_kim/GitHub/Noon/App/src/com/noon/app/btn_shot_plus3.png"));
			btnShot3.setBounds(264, 151, 45, 31);
		}
		return btnShot3;
	}

	private JButton getBtnSyrupNot() {
		if (btnSyrupNot == null) {
			btnSyrupNot = new JButton("");
			btnSyrupNot.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					syrupCheck = "";
					optionInfo();
				}
			});
			btnSyrupNot
					.setIcon(new ImageIcon("/Users/sangwon_kim/GitHub/Noon/App/src/com/noon/app/btn_syrup_basic1.png"));
			btnSyrupNot.setBounds(87, 216, 45, 31);
		}
		return btnSyrupNot;
	}

	private JButton getBtnSyrupHazelnut() {
		if (btnSyrupHazelnut == null) {
			btnSyrupHazelnut = new JButton("");
			btnSyrupHazelnut.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					syrupCheck = "+헤이즐넛시럽";
					optionInfo();
				}
			});
			btnSyrupHazelnut.setIcon(
					new ImageIcon("/Users/sangwon_kim/GitHub/Noon/App/src/com/noon/app/btn_syrup_hazelnut5.png"));
			btnSyrupHazelnut.setBounds(151, 216, 76, 31);
		}
		return btnSyrupHazelnut;
	}

	private JButton getBtnSyrupVanila() {
		if (btnSyrupVanila == null) {
			btnSyrupVanila = new JButton("");
			btnSyrupVanila.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					syrupCheck = "+바닐라시럽";
					optionInfo();
				}
			});
			btnSyrupVanila.setIcon(
					new ImageIcon("/Users/sangwon_kim/GitHub/Noon/App/src/com/noon/app/btn_syrup_vanila5.png"));
			btnSyrupVanila.setBounds(245, 216, 63, 31);
		}
		return btnSyrupVanila;
	}

	// =============================

	private JLabel getLblOptionReset() {
		if (lblOptionReset == null) {
			lblOptionReset = new JLabel("");
			lblOptionReset.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					hoticeCheck = "Hot";
					sizeCheck = "Tall";
					shotCheck = "";
					syrupCheck = "";
					lblOrderQuentity.setText("1");
					optionInfo();
				}

				@Override
				public void mousePressed(MouseEvent e) {
					lblOptionReset.setIcon(new ImageIcon(
							"/Users/sangwon_kim/GitHub/Noon/App/src/com/noon/app/btn_option_cancel_all_C.png"));
				}

				@Override
				public void mouseReleased(MouseEvent e) {
					lblOptionReset.setIcon(new ImageIcon(
							"/Users/sangwon_kim/GitHub/Noon/App/src/com/noon/app/btn_option_cancel_all.png"));
				}
			});
			lblOptionReset.setIcon(
					new ImageIcon("/Users/sangwon_kim/GitHub/Noon/App/src/com/noon/app/btn_option_cancel_all.png"));
			lblOptionReset.setBounds(15, 580, 166, 45);
		}
		return lblOptionReset;
	}

	private JLabel getLblNewLabel_5() {
		if (lblNewLabel_5 == null) {
			lblNewLabel_5 = new JLabel("");
			lblNewLabel_5
					.setIcon(new ImageIcon("/Users/sangwon_kim/GitHub/Noon/App/src/com/noon/app/btn_round_base.png"));
			lblNewLabel_5.setBounds(193, 580, 167, 45);
		}
		return lblNewLabel_5;
	}

	private JLabel getBtnMinus() {
		if (btnMinus == null) {
			btnMinus = new JLabel("");
			btnMinus.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if (quantity > 1) {
						quantity--;
					}
					getLblOrderQuentity().setText(Integer.toString(quantity));
				}

				@Override
				public void mousePressed(MouseEvent e) {
					btnMinus.setIcon(
							new ImageIcon("/Users/sangwon_kim/GitHub/Noon/App/src/com/noon/app/btn_round_minus_C.png"));
				}

				@Override
				public void mouseReleased(MouseEvent e) {
					btnMinus.setIcon(
							new ImageIcon("/Users/sangwon_kim/GitHub/Noon/App/src/com/noon/app/btn_round_minus.png"));
				}
			});
			btnMinus.setHorizontalAlignment(SwingConstants.CENTER);
			btnMinus.setIcon(new ImageIcon("/Users/sangwon_kim/GitHub/Noon/App/src/com/noon/app/btn_round_minus.png"));
			btnMinus.setBounds(189, 576, 53, 53);
		}
		return btnMinus;
	}

	private JLabel getBtnPlus() {
		if (btnPlus == null) {
			btnPlus = new JLabel("");
			btnPlus.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if (quantity <= 20) {
						quantity++;
					}
					getLblOrderQuentity().setText(Integer.toString(quantity));
				}

				@Override
				public void mousePressed(MouseEvent e) {
					btnPlus.setIcon(
							new ImageIcon("/Users/sangwon_kim/GitHub/Noon/App/src/com/noon/app/btn_round_plus_C.png"));
				}

				@Override
				public void mouseReleased(MouseEvent e) {
					btnPlus.setIcon(
							new ImageIcon("/Users/sangwon_kim/GitHub/Noon/App/src/com/noon/app/btn_round_plus.png"));
				}
			});
			btnPlus.setHorizontalAlignment(SwingConstants.CENTER);
			btnPlus.setIcon(new ImageIcon("/Users/sangwon_kim/GitHub/Noon/App/src/com/noon/app/btn_round_plus.png"));
			btnPlus.setBounds(311, 576, 53, 53);
		}
		return btnPlus;
	}

	private JLabel getLblOrderQuentity() {
		if (lblOrderQuentity == null) {
			lblOrderQuentity = new JLabel("1");
			lblOrderQuentity.setForeground(new Color(176, 108, 89));
			lblOrderQuentity.setFont(new Font("SansSerif", Font.PLAIN, 18));
			lblOrderQuentity.setHorizontalAlignment(SwingConstants.CENTER);
			lblOrderQuentity.setBounds(244, 580, 66, 45);
		}
		return lblOrderQuentity;
	}

	private JLabel getLblBtnPutIn() {
		if (lblBtnPutIn == null) {
			lblBtnPutIn = new JLabel("");
			lblBtnPutIn.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					selectedOptionCheck();
					insertActionCart();
				}

				@Override
				public void mousePressed(MouseEvent e) {
					lblBtnPutIn.setIcon(
							new ImageIcon("/Users/sangwon_kim/GitHub/Noon/App/src/com/noon/app/btn_put_in_C.png"));
				}

				@Override
				public void mouseReleased(MouseEvent e) {
					lblBtnPutIn.setIcon(
							new ImageIcon("/Users/sangwon_kim/GitHub/Noon/App/src/com/noon/app/btn_put_in.png"));
				}
			});
			lblBtnPutIn.setIcon(new ImageIcon("/Users/sangwon_kim/GitHub/Noon/App/src/com/noon/app/btn_put_in.png"));
			lblBtnPutIn.setBounds(15, 644, 345, 61);
		}
		return lblBtnPutIn;
	}

	private JLabel getLblpn1Background() {
		if (lblpn1Background == null) {
			lblpn1Background = new JLabel("");
			lblpn1Background.setIcon(
					new ImageIcon("/Users/sangwon_kim/GitHub/Noon/App/src/com/noon/app/pn_option_category_coffee.png"));
			lblpn1Background.setBounds(0, 0, 335, 277);
		}
		return lblpn1Background;
	}

	// -----------------------------------------------
	private JPanel getPnCategoryTeaBeverage() {
		if (pnCategoryTeaBeverage == null) {
			pnCategoryTeaBeverage = new JPanel();
			pnCategoryTeaBeverage.setBackground(new Color(255, 0, 0, 0));
			pnCategoryTeaBeverage.setBounds(20, 244, 335, 277);
			pnCategoryTeaBeverage.setLayout(null);
			pnCategoryTeaBeverage.add(getBtnHotPn2());
			pnCategoryTeaBeverage.add(getBtnIcePn2());
			pnCategoryTeaBeverage.add(getBtnSizeTallPn2());
			pnCategoryTeaBeverage.add(getBtnSizeRegularPn2());
			pnCategoryTeaBeverage.add(getBtnSizeGrandePn2());
			pnCategoryTeaBeverage.add(getLabel_1_1());
			//
			if (Panel05Order03Menu.selectedCategory.equals("tea")
					|| Panel05Order03Menu.selectedCategory.equals("beverage")) {
			}else {
				pnCategoryTeaBeverage.setVisible(false);
			}
			System.out.println(Panel05Order03Menu.selectedCategory);
		}
		return pnCategoryTeaBeverage;
	}

	private JButton getBtnHotPn2() {
		if (btnHotPn2 == null) {
			btnHotPn2 = new JButton("");
			btnHotPn2.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					hoticeCheck = "Hot";
					optionInfo();
				}
			});
			btnHotPn2.setIcon(new ImageIcon("/Users/sangwon_kim/GitHub/Noon/App/src/com/noon/app/btn_hot1.png"));
			btnHotPn2.setBounds(87, 55, 77, 32);
		}
		return btnHotPn2;
	}

	private JButton getBtnIcePn2() {
		if (btnIcePn2 == null) {
			btnIcePn2 = new JButton("");
			btnIcePn2.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					hoticeCheck = "Ice";
					optionInfo();
				}
			});
			btnIcePn2.setIcon(new ImageIcon("/Users/sangwon_kim/GitHub/Noon/App/src/com/noon/app/btn_ice1.png"));
			btnIcePn2.setBounds(232, 55, 77, 32);
		}
		return btnIcePn2;
	}

	private JButton getBtnSizeTallPn2() {
		if (btnSizeTallPn2 == null) {
			btnSizeTallPn2 = new JButton("");
			btnSizeTallPn2.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					sizeCheck = "Tall";
					optionInfo();
				}
			});
			btnSizeTallPn2
					.setIcon(new ImageIcon("/Users/sangwon_kim/GitHub/Noon/App/src/com/noon/app/btn_size_tall.png"));
			btnSizeTallPn2.setBounds(87, 189, 45, 31);
		}
		return btnSizeTallPn2;
	}

	private JButton getBtnSizeRegularPn2() {
		if (btnSizeRegularPn2 == null) {
			btnSizeRegularPn2 = new JButton("");
			btnSizeRegularPn2.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					sizeCheck = "Regular";
					optionInfo();
				}
			});
			btnSizeRegularPn2
					.setIcon(new ImageIcon("/Users/sangwon_kim/GitHub/Noon/App/src/com/noon/app/btn_size_regular.png"));
			btnSizeRegularPn2.setBounds(146, 189, 78, 31);
		}
		return btnSizeRegularPn2;
	}

	private JButton getBtnSizeGrandePn2() {
		if (btnSizeGrandePn2 == null) {
			btnSizeGrandePn2 = new JButton("");
			btnSizeGrandePn2.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					sizeCheck = "Grande";
					optionInfo();
				}
			});
			btnSizeGrandePn2
					.setIcon(new ImageIcon("/Users/sangwon_kim/GitHub/Noon/App/src/com/noon/app/btn_size_grande.png"));
			btnSizeGrandePn2.setBounds(237, 189, 72, 31);
		}
		return btnSizeGrandePn2;
	}

	private JLabel getLabel_1_1() {
		if (lblPn2Background == null) {
			lblPn2Background = new JLabel("");
			lblPn2Background.setIcon(new ImageIcon(
					"/Users/sangwon_kim/GitHub/Noon/App/src/com/noon/app/pn_option_category_tea&beverage.png"));
			lblPn2Background.setBounds(0, 0, 335, 277);
		}
		return lblPn2Background;
	}

	private JLabel getLblOptionInfo() {
		if (lblOptionInfo == null) {
			lblOptionInfo = new JLabel("Hot / Tall");
			lblOptionInfo.setFont(new Font("SansSerif", Font.PLAIN, 16));
			lblOptionInfo.setHorizontalAlignment(SwingConstants.TRAILING);
			lblOptionInfo.setBounds(30, 533, 321, 32);
		}
		return lblOptionInfo;
	}

	// Function
	private void optionInfo() {
		if (Panel05Order03Menu.selectedCategory.equals("coffee")) {
			lblOptionInfo.setText(hoticeCheck + " / " + sizeCheck + " / " + shotCheck + " / " + syrupCheck);
		} else {
			lblOptionInfo.setText(hoticeCheck + " / " + sizeCheck);
		}
	}

	// 옵션체크
	private void selectedOptionCheck() {
		if (hoticeCheck == "Hot") {
			hotice = 0;
		} else {
			hotice = 1;
		}

		if (sizeCheck == "Tall") {
			size = 0;
		} else if (sizeCheck == "Regular") {
			size = 1;
		} else {
			size = 2;
		}

		if (shotCheck == "") {
			shot = 0;
		} else if (shotCheck == "+1샷") {
			shot = 500;
		} else if (shotCheck == "+2샷") {
			shot = 1000;
		} else {
			shot = 1500;
		}

		if (syrupCheck == "") {
			syrup = 0;
		} else if (syrupCheck == "+헤이즐넛시럽") {
			syrup = 1;
		} else {
			syrup = 2;
		}
	}

	// 담기
	private void insertActionCart() {
		DaoOrder daoOrder = new DaoOrder(Panel05Order01Shop.ordertime, hotice, quantity, shot, syrup, size,
				Panel05Order03Menu.selectedPrice, Panel01Login.id, Panel05Order03Menu.selectedSetno,
				Panel05Order03Menu.selectedMenu, Panel05Order01Shop.shopcode, "none");
		if (daoOrder.insertActionCart() == 1) {
			setVisible(false);
			Main.frame.getContentPane().add(new Panel05Order05Cart());
		} else {
			JOptionPane.showMessageDialog(null, "서버점검중입니다. 불편을 끼쳐드려 죄송합니다.");
		}
	}

} // End